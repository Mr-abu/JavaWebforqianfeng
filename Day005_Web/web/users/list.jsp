<%@ page import="com.qf.www.entity.Dept" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户查询</title>
</head>
<body>
    <%
        List<Dept> list = (List<Dept>)request.getAttribute("list");
    %>
    <table border="1">
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工工作</th>
        </tr>

    <%
        for (Dept dept : list) {

    %>

    <tr>
        <td><%=dept.getEmpno()%></td>
        <td><%=dept.getEname()%></td>
        <td><%=dept.getJob()%></td>
    </tr>

    <%
        }
    %>
</table>
</body>
</html>
