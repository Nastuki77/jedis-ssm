package org.jedis.web.controller.base;

import org.jedis.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nastuki on 2016/10/9.
 */
public class BaseController {

    @Autowired
    protected IUserService userService;

}
