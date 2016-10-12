package org.jedis.web.filter;


import org.jedis.config.MyAppConfig;

import javax.servlet.*;
import java.io.IOException;


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

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain arg2) throws IOException, ServletException {

    }


    @Override
    public void destroy() {

    }


}
