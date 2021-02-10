package com.qf.www.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionsServlet", value = "/sessions")
public class SessionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取Session 先判断请求内容里面是否包含了session。如果没有则会自动创建
        HttpSession session = request.getSession();

        System.out.println(session.getId());
        System.out.println(session.getMaxInactiveInterval());

//        session.setMaxInactiveInterval(20*60);  //秒为单位 程序进来先加载web.xml相对于web.xml是作为第二次修改

        Test test = new Test();
        test.name="胡高俊";
        test.age=23;

        session.setAttribute("name", test); //session实现跨Servlet资源共享
    }

}
    class Test {
        String name;
        int age;

        @Override
        public String toString() {
            return "Test{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }