
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/Day005_Web/update" method="post">

    <table>
        <tr>
            <td>员工编号：</td>
            <td><input type="text" name="empno"></td>
        </tr>
        <tr>
            <td>员工姓名：</td>
            <td><input type="text" name="ename"></td>
        </tr> bv
        <tr>
            <td>员工工作：</td>
            <td><input type="text" name="job"></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
            <td><input type="reset" name="恢复"></td>
        </tr>
    </table>
</form>

</body>
</html>
