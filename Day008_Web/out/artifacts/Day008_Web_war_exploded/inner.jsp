
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
    %>

<%=username%><br>

${param.username}<br>
${paramValues.hobby[0]}<br>
${header.Accept}<br>
${headerValues["accept-encoding"][0]}<br>
${cookie.JSESSIONID}<br>
${initParam.username}



</body>
</html>
