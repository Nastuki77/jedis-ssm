package org.jedis.web.controller;

import org.jedis.entity.User;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.jedis.web.controller.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/9.
 */
@Controller
@Module(name = "用户", value = "user")
@RequestMapping("/user")
public class UserController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/load")
    public String load(Model model) {

        List<User> user = this.userService.getUserAll();

        model.addAttribute("user", user);
        return "common/menu";
    }

    @Permissions(name = "主页", value = "home")
    @RequestMapping("/loginConfirm")
    public String loginConfirm(Model model) {
        return "common/home";
    }

    @RequestMapping("/skipPage")
    public String skipPage(Model model) {
        return "user/skipPage";
    }

}
