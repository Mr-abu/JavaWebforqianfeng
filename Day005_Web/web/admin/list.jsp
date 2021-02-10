<%@ page import="com.qf.www.entity.Dept" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员查询</title>
</head>
<body>
<a href="/Day005_Web/admin/insert.jsp">新增</a>
<%
    List<Dept> list = (List<Dept>) request.getAttribute("list");
%>
    <table border="1">
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工工作</th>
            <th>操作</th>
        </tr>
<%
    for (Dept dept : list) {

%>
        <tr>
            <td><%=dept.getEmpno()%></td>
            <td><%=dept.getEname()%></td>
            <td><%=dept.getJob()%></td>
            <td><a href="/Day005_Web/getdept?empno=<%=dept.getEmpno()%>">修改</a>&nbsp;&nbsp;<a href="/Day005_Web/delete?no=<%=dept.getEmpno()%>">删除</a> </td>
        </tr>
<%
    }
%>
    </table>
<a href="/Day005_Web/logout">注销</a>
</body>
</html>
