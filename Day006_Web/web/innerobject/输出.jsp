<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021-01-31
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    out.print("A ！<br>");
    out.print("B ！<br>");
    writer.println("C！<br>");   // print CAB

//    PrintWriter writer2= response.getWriter();
    out.print("A ！<br>");
    out.print("B ！<br>");
    out.flush();
    writer.println("C！<br>");   // print ABC

    //getWrite()直接写到response中，效率比JspWriter高
    //而out输出到缓冲区中，没有写到response中
    //JspWriter (out) 适用于Jsp, 而getWriter()方法适用于servlet
%>
<h3>哈哈哈哈</h3>
</body>
</html>
