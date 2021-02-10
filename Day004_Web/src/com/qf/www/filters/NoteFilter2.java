package com.qf.www.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = {"CountsServlet", "TestServlet"})
public class NoteFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("注解2过滤之前。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("注解2过滤之后。。。");
    }

    @Override
    public void destroy() {

    }
}
