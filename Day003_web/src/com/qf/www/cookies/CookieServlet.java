package com.qf.www.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "CookieServlet", value = "/cs")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建了一个cookie对象， 默认cookie的生命周期：浏览器关闭！
        //这里是Encoder.encoder 编码
        Cookie cookie = new Cookie(URLEncoder.encode("姓名", "UTF-8"), "高强");
        //1.1   对现有的Cookie对象做属性的更新
        //设置cookie的生命周期：负数-->浏览器内存里 0-->失效 正数---->生效时间
        cookie.setMaxAge(60*10);
        //1.2   Cookie的共享范围：同一个项目下。 /当前服务器下
        cookie.setPath("/");

        //2.给浏览器 response发送给浏览器
        response.addCookie(cookie);
    }
}
