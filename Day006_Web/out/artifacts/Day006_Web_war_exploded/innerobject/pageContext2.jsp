<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-02-01
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //存在是当前页面作用域
    pageContext.setAttribute("user", "user");
    //存在指定的作用域里
    pageContext.setAttribute("user","123456",PageContext.REQUEST_SCOPE);
    //存在session里
    pageContext.setAttribute("user","嘿嘿",PageContext.SESSION_SCOPE);
    //存在application
    pageContext.setAttribute("user", 5, PageContext.APPLICATION_SCOPE);
%>

<%--从小到大找，如果有重复的名称，找到就返回--%>
<%=pageContext.findAttribute("user")
        // -->user
%>
</body>
</html>
