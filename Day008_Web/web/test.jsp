
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <jsp:forward page="inner.jsp">
        <jsp:param name="username" value="aqiang"/>
        <jsp:param name="hobby" value="lanqiu"/>
        <jsp:param name="hobby" value="zuqiu"/>
        <jsp:param name="hobby" value="yumaoqiu"/>
    </jsp:forward>

</body>
</html>
