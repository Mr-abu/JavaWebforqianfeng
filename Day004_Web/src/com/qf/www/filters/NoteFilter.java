package com.qf.www.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = {"CountsServlet","TestServlet"})
public class NoteFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("注解1过滤前。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("注解1过滤后。。。");
    }

    @Override
    public void destroy() {

    }
}
