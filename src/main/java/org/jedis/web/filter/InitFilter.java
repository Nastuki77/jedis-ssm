package org.jedis.web.filter;


import org.jedis.config.MyAppConfig;
import org.jedis.entity.Allows;
import org.jedis.entity.Permit;
import org.jedis.utils.MyUtils;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.jedis.web.controller.initUtils;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: InitFilter
 * @Description: 页面初始化常用配置
 * Created by Nastuki on 2016/10/10.
 */
public class InitFilter implements Filter {


    @Override
    public void init(FilterConfig fc) throws ServletException {

        fc.getServletContext().setAttribute("baseUrl", MyAppConfig.APP_CONFIGS.get("baseUrl"));
        fc.getServletContext().setAttribute("cssUrl", MyAppConfig.APP_CONFIGS.get("cssUrl"));
        fc.getServletContext().setAttribute("jsUrl", MyAppConfig.APP_CONFIGS.get("jsUrl"));
        fc.getServletContext().setAttribute("imageUrl", MyAppConfig.APP_CONFIGS.get("imageUrl"));
        //initUtils initUtils = new initUtils();
        //initUtils.inits();

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain arg2) throws IOException, ServletException {

    }


    @Override
    public void destroy() {

    }


}
