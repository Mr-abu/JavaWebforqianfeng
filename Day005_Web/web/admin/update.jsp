<%@ page import="com.qf.www.entity.Dept" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Dept dept = (Dept)request.getAttribute("dept");
%>
<form action="/Day005_Web/update" method="post">

    <table>
        <tr>
            <td>员工编号：</td>
            <td><input type="text" name="empno" value="<%=dept.getEmpno()%>" readonly></td>
        </tr>
        <tr>
            <td>员工姓名：</td>
            <td><input type="text" name="ename" value="<%=dept.getEname()%>"></td>
        </tr>
        <tr>
            <td>员工工作：</td>
            <td><input type="text" name="job" value="<%=dept.getJob()%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

</body>
</html>
