package com.riabushenkp.auth;

import com.riabushenkp.auth.domain.Client;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {UserLoginFilter.USER_FILTER + "*", UserLoginFilter.ADMIN_FILTER + "*"})
public class UserLoginFilter implements Filter{
    public static final String USER_FILTER = "/user/";
    public static final String ADMIN_FILTER = "/admin/";

    @Inject
    private AuthBean authBean;
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if(authBean.getRole() !=null){
            String uri = request.getRequestURI();
            String beginOfAdminUri = request.getContextPath()+ ADMIN_FILTER;
            if (uri.startsWith(beginOfAdminUri) && authBean.getRole() != Client.Role.ADMIN) {
                response.sendRedirect(request.getContextPath() + "/errors.xhtml");
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
            return;
    }
        authBean.setRequestedPage(request.getRequestURI());
        response.sendRedirect(request.getContextPath()+ "/login.xhtml");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
