<%@ page import="com.qf.www.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-01-30
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建对象</title>
</head>
<body>

    <%
        //Java代码创建。直接创建
        User user = new User();
        user.setUsername("强");
        user.setPassword("123456");
    %>
<h1>当前登录的用户名为：<%=user.getUsername()%></h1>

<%--    1.声明引用 2.查询有没有重复的 3.创建新对象 4.存到作用域 5.赋值--%>
<jsp:useBean id="users" class="com.qf.www.entity.User"></jsp:useBean>
<jsp:setProperty name="users" property="username" value="嗨"></jsp:setProperty>
<jsp:setProperty name="users" property="password" value="123456"></jsp:setProperty>
<h1>当前登录的用户名为：<jsp:getProperty name="users" property="username"/> </h1>

<%--    与表单进行匹配：发送请求过来的页面，表单每个标签的name要与实体类的属性名完全一致--%>
<jsp:useBean id="user2" class="com.qf.www.entity.User"></jsp:useBean>
<jsp:setProperty name="user2" property="*"></jsp:setProperty>
<%--<jsp:setProperty name="user2" property="password"></jsp:setProperty>--%>
    <%
        request.setAttribute("users", user2);
        request.getRequestDispatcher("/test").forward(request, response);
    %>
    <h1>当前登录的用户名为：<jsp:getProperty name="user2" property="username"/><br>
        密码为：<jsp:getProperty name="user2" property="password"/>
    </h1>
</body>
</html>
