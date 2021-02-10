package com.qf.www.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "LoginFilter", value = "/login.html")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //Session里取username
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            response.sendRedirect("/Day005_Web/welcome.html");
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies!=null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    //如果当前cookie里面有userinfo的name,证明用户登录过
                    if (name.equals("userinfo")) {
                        String value = cookie.getValue();
                        //aqiang#123456
                        String[] split = value.split("#");
                        session.setAttribute("username", split[0]);
                        response.sendRedirect("/Day005_Web/welcome.html");
                    }
                }
            }
        }
        //cookie里取用户名和密码

        //放行。。没有登陆过 ，也没有自动登录 ，放行到 login.html
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
