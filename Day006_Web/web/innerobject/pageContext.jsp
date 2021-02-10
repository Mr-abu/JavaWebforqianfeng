<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-02-01
  Time: 14:10
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
    pageContext.setAttribute("aqiang","123456",PageContext.REQUEST_SCOPE);
    //存在session里
    pageContext.setAttribute("name","嘿嘿",PageContext.SESSION_SCOPE);
    //存在application
    pageContext.setAttribute("deptno", 5, PageContext.APPLICATION_SCOPE);
%>

<%=pageContext.getAttribute("user")%>
<%=request.getAttribute("aqiang")%>
<%=session.getAttribute("name")%>
<%=application.getAttribute("deptno")%>

<%--=用pageContext在所有的作用域里取值， getAttribute方法需要指定名称，作用域--%>
<br><h3>pageContext取值</h3>
<%=pageContext.getAttribute("aqiang", 2)%>
<%=pageContext.getAttribute("name",3)%>
<%=pageContext.getAttribute("deptno",4)%>
<br>

<%--不知道在哪个作用域里有这个名称 从小到大找--%>
<%=pageContext.findAttribute("deptno")%>


</body>
</html>
