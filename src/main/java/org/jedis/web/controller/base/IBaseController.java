package org.jedis.web.controller.base;

import org.jedis.service.impl.IuserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nastuki on 2016/10/10.
 */
public class IBaseController {

    @Autowired
    private IuserService userService;

    public IuserService getUserService() {
        return userService;
    }

}
