
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/updateUser" method="post">
        <table>
        <tr>
            <td>用户名：</td>
            <td><input name="username" value="${user.username}" id="username"></td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td><input name="realName" value="${user.realName}" id="realName"></td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td><input name="phone" value="${user.phone}" id="phone"></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input name="address" value="${user.address}" id="address"></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><input name="email" value="${user.email}" id="email"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input name="password" value="${user.password}" id="password"></td>
        </tr>

            <tr>
                <td><input type="submit" value="提交"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</body>
</html>
