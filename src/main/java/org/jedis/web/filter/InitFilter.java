package org.jedis.web.filter;


import org.jedis.config.MyAppConfig;
import org.jedis.dao.RedisDao;
import org.jedis.entity.Permit;
import org.jedis.service.impl.IUserService;
import org.jedis.utils.MyUtils;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.jedis.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.servlet.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: InitFilter
 * @Description: 页面初始化常用配置
 * Created by Nastuki on 2016/10/10.
 */
public class InitFilter implements Filter {

    @Autowired
    private IUserService userService;

    @Override
    public void init(FilterConfig fc) throws ServletException {

        fc.getServletContext().setAttribute("baseUrl", MyAppConfig.APP_CONFIGS.get("baseUrl"));
        fc.getServletContext().setAttribute("cssUrl", MyAppConfig.APP_CONFIGS.get("cssUrl"));
        fc.getServletContext().setAttribute("jsUrl", MyAppConfig.APP_CONFIGS.get("jsUrl"));
        fc.getServletContext().setAttribute("imageUrl", MyAppConfig.APP_CONFIGS.get("imageUrl"));


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain arg2) throws IOException, ServletException {

    }


    @Override
    public void destroy() {

    }


}
