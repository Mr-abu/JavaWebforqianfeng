
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text"><br>
        密码：<input type="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
