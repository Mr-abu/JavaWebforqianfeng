<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-01-31
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 演示从作用域里面取值--%>
<%

    Object username = request.getAttribute("username");
    Object username1 = session.getAttribute("username1");
    Object username2 = application.getAttribute("username2");
    Object username3 = pageContext.getAttribute("username3");

%>
<%=username
%>
<%=username1
%>
<%=username2
%>
<%=username3
%>


</body>
</html>
