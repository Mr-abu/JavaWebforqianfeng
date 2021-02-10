<%@page isErrorPage="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    九大内置对象    --%>
<%--
    request -->jspService提供
    response  -->jspService提供
    pageContext -->jspService自动创建
    exception  -->用指令标签 isErrorPage=true来指定指定为我们创建
    out -->jspService自动创建
    application -->jspService自动创建
    session -->jspService自动创建
    page -->jspService自动创建
    config -->jspService自动创建
--%>

<%
    //request对应的是一次请求， 重定向或跨越超过一个页面，就丢失了
    request.setAttribute("username", "aqiang");
    //request.getRequestDispatcher("test.jsp").forward(request, response);
    //session对应一次回话，浏览器关闭就丢失了
    session.setAttribute("username1","铁拳");
    //application对应一次服务器启动，关闭即销毁
    application.setAttribute("username2","大象");
    //pageContext的自身作用域仅能作用在当前Jsp,不能跨请求
    pageContext.setAttribute("username3","小蚂蚁");
    response.sendRedirect("test.jsp");

    String servletName = config.getServletName();
    System.out.println(servletName); //print:JSP
%>


<a href="test.jsp">跳转</a>
</body>
</html>
