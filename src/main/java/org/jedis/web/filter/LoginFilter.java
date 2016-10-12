package org.jedis.web.filter;

import org.jedis.entity.UserVo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: LoginFilter
 * @Description: 页面登陆验证
 * Created by Nastuki on 2016/10/10.
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);
        UserVo userVo = (UserVo) session.getAttribute("UserVo");

        if (userVo == null || "".equals(userVo)) {
            //response.sendRedirect(request.getContextPath() + "/login/login.jsp");
            request.getRequestDispatcher("/user/load").forward(request,response);
            return;
        }

        filterChain.doFilter(request, response);
        return;
    }

    @Override
    public void destroy() {

    }

}
