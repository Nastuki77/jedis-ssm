package org.jedis.web.controller;

import org.jedis.entity.Allows;
import org.jedis.entity.Permit;
import org.jedis.entity.User;
import org.jedis.utils.MyUtils;
import org.jedis.web.annocation.Module;
import org.jedis.web.controller.base.BaseController;
import org.jedis.web.vo.permitVo.permitVo;
import org.jedis.web.vo.permitVo.valueVo;
import org.jedis.web.vo.utilsVo.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nastuki on 2016/10/13.
 */
@Controller
@Module(name = "登陆", value = "login")
@RequestMapping("/login")
public class LoginController extends BaseController {

    @RequestMapping("/load")
    public String login(Model model) {

        return "login/login";
    }

    @RequestMapping("/loginConfirm")
    public String loginConfirm(Model model) {
        return "common/home";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, Model model) {

        String username = request.getParameter("usernamesignup");
        String email = request.getParameter("emailsignup");
        String password = request.getParameter("passwordsignup");
        String passwordConfirm = request.getParameter("passwordsignup_confirm");
        int value = 0;
        if (password.equals(passwordConfirm)) {
            value = this.userService.getUseDao().addUser(username.trim(),
                    DigestUtils.md5DigestAsHex(password.trim().getBytes()),email.trim());
        }
        if (value == 0) {
            return "login/register";
        } else {
            return "login/login";
        }

    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int value = 0;
        User user = this.userService.getUseDao().getUser(username, DigestUtils.md5DigestAsHex(password.trim().getBytes()));

        if (user != null) {
            return "login/login";
        } else {
            String[] strings = user.getPermissions().split(",");
            List<Long> ids = new ArrayList<Long>();
            List<Permit> permits = null;
            List<Allows> list = new ArrayList<Allows>();
            for (String s : strings) {
                if (MyUtils.isNotEmpty(s)) {
                    ids.add(Long.valueOf(s));
                }
            }
            if (ids.size() > 0) {
                permits = this.userService.getPermitDao().queryPermissionByUserId(ids);
            }
            Allows allows = null;
            for (Permit permit : permits) {
                allows = new Allows();
                allows.setModule(permit.getModuleValue());
                allows.setPermission(permit.getPermitValue());

                list.add(allows);
            }
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setId(user.getId());
            loginInfo.setAllows(list);
            loginInfo.setName(user.getUsername());
            loginInfo.setEmail(user.getEmail());
            request.getSession().setAttribute("LoginInfo", loginInfo);
            return "home/homePage";
        }

    }

    @RequestMapping("/permitPage")
    public String permitPage(HttpServletRequest req, Model model) {

        LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("LoginInfo");

        List<Permit> permits = this.userService.getPermitDao().queryAll();
        List<permitVo> permitVos = new ArrayList<permitVo>();
        permitVo Vo = null;
        List<valueVo> values = new ArrayList<valueVo>();
        valueVo value = null;
        if (MyUtils.isNotEmpty(loginInfo)) {
            for (Permit permit : permits) {
                Vo = new permitVo();
                Vo.setModuleValue(permit.getModuleValue());
                for (Permit p : permits) {
                    if(permit.getModuleValue().equals(p.getModuleValue())){
                        value = new valueVo();
                        value.setPermitValue(p.getPermitValue());
                        value.setFlag(0);
                        for (Allows allows : loginInfo.getAllows()) {
                            if (allows.getModule().equals(permit.getModuleValue())&&
                                    allows.getPermission().equals(permit.getPermitValue())) {
                                value.setFlag(1);
                            }
                        }
                        values.add(value);
                    }
                }
                Vo.setValueVos(values);
                permitVos.add(Vo);
            }
        } else {
            return "login/login";
        }


        model.addAttribute("permits", permitVos);

        return "permit/permitPage";
    }


}
