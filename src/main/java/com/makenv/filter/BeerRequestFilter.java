package com.makenv.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BeerRequestFilter implements Filter {

    /*
     * 记录访问的用户
     */
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String name = httpServletRequest.getRemoteUser();
        if (name != null) {
            filterConfig.getServletContext().log("User" + name + "is updating");
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        //完成清理工作
    }
}
