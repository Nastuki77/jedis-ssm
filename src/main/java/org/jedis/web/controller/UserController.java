package org.jedis.web.controller;

import org.jedis.entity.users;
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
@Module(name = "SSM", value = "paymentRequest")
@RequestMapping("/user")
public class UserController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Permissions(name = "home", value = "home")
    @RequestMapping("/load")
    public String load(Model model){

        List<users> user = this.getUserService().getUserAlll();

        model.addAttribute("user",user);
        return "user/userPage";
    }

}
