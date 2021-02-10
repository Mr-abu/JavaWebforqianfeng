package com.qf.www.filters;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤之前。。。");
        //调用下一个过滤器，如果没有， 则传递到servlet
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤之后。。。");
    }

    @Override
    public void destroy() {

    }
}
