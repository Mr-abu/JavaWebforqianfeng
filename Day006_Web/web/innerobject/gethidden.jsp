<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-02-01
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
       pageContext.forward("test.jsp");//转发
       pageContext.include("test.jsp");//动态包含一个页面
    %>
</body>
</html>
