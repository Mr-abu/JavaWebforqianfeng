package com.qf.www.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ClearServlet", value = "/clears")
public class ClearServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();   //让session失效
        //取值的E258CCFA2E220ACF29CF4C4660A89D41 (执行session之后getsession)
        //Test{name='胡高俊', age=23}
        //取值的C19FBB81CED5D6C43722C8A795AFC828 (执行clears之后)
        //null

    }
}
