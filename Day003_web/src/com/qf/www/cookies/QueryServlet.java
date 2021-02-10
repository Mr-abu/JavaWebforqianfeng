package com.qf.www.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(name = "QueryServlet" ,value = "/qs")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求头的信息都在request
        Cookie[] cookies = request.getCookies();
        if (cookies.length!=0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                //注意：这里应该是Decoder.decoder 解码
                if (URLDecoder.decode(name, "UTF-8").equals("姓名")) {
                    if (cookie.getValue().equals("高强")) {
                        System.out.println("当前已经登录过了");
                    }
                }
            }
        }
    }
}
