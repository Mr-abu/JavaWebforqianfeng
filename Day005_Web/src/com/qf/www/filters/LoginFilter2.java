package com.qf.www.filters;

import com.qf.www.entity.User;
import com.qf.www.service.UserService;
import com.qf.www.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter2", value = "/login.html")
public class LoginFilter2 implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if (user!=null) {
            response.sendRedirect("/Day005_Web/welcome.html");
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies!=null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if (name.equals("userinfo")) {
                        String value = cookie.getValue();
                        String[] split = value.split("#");
                        UserService userService = new UserServiceImpl();
                        User user1 = userService.checkUser(split[0], split[1]);
                        if (user1 !=null) {
                            if (user1.getAccess()==1) {
                                //管理员：进查询所有页面 (包含修改和删除)
                                response.sendRedirect("/Day005_Web/admin");
                            } else {
                                //用户：进查询所有页面
                                response.sendRedirect("/Day005_Web/getall");
                            }

                        } else {
                            response.sendRedirect("/Day005_Web/fail.html");
                        }
                    }
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void destroy() {
    }

}
