package org.jedis.web.controller.base;

import org.jedis.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Nastuki on 2016/10/9.
 */
@Controller
public class BaseController {

    @Autowired
    protected IUserService userService;

}
