<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>查询所有员工</title>
  </head>
  <body>
    <table border="1">
      <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>员工职位</th>
        <th>直属领导</th>
        <th>入职日期</th>
        <th>工资</th>
        <th>奖金</th>
        <th>部门编号</th>
        <th>操作</th>
      </tr>
      <c:forEach items = "${list}" var = "emp">
        <tr>
          <td>${emp.empno}</td>
          <td>${emp.ename}</td>
          <td>${emp.job}</td>
          <td>${emp.mgr}</td>
          <td>${emp.hiredate}</td>
          <td>${emp.sal}</td>
          <td>${emp.comm}</td>
          <td>${emp.deptno}</td>
          <td><a>修改</a><a>删除</a></td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>
