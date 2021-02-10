
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TL表达式</title>
</head>
<body>
    <%
        String s1 ="abc";
        String s2 = new String ("abc");
        request.setAttribute("s1",s1);
        request.setAttribute("s2",s2);
        String s3 = null;
        String s4 = "";
        String s5 = " ";
        request.setAttribute("s3",s3);
        request.setAttribute("s4",s4);
        request.setAttribute("s5",s5);
    %>
    ${s3 == s4}<br>
    ${s3 eq s4}<br>
    ${s4 == s5}<br>
    ${empty s3}<br>
<%--    empty关键只要是内容为空 true--%>
    ${empty s4}<br>
    ${empty s5}<br>
    <hr>

</body>
</html>
