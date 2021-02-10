<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update" method="post">
    <table>
        <tr>
            <td>员工编号：</td>
            <td><input type="text"value="${emp.empno}" name="empno" readonly></td>
        </tr>
        <tr>
            <td>员工姓名：</td>
            <td><input type="text"value="${emp.ename}" name="ename"></td>
        </tr>
        <tr>
            <td>员工职位：</td>
            <td><input type="text"value="${emp.job}" name="job"></td>
        </tr>
        <tr>
            <td>直属领导：</td>
            <td><input type="text"value="${emp.mgr}" name="mgr"></td>
        </tr>
        <tr>
            <td>入职日期：</td>
            <td><input type="date"value="${emp.hiredate}" name="hiredate"></td>
        </tr>
        <tr>
            <td>工资：</td>
            <td><input type="text"value="${emp.sal}" name="sal"></td>
        </tr>
        <tr>
            <td>奖金：</td>
            <td><input type="text"value="${emp.comm}" name="comm"></td>
        </tr><tr>
            <td>部门名称：</td>
            <td><select name="deptno" id="">
                <c:forEach items="${allDept}" var = "dept">
                <option value="${dept.deptno}"

                    <c:if test="${emp.deptno==dept.deptno}">
                        selected
                    </c:if>

                >${dept.dname}</option>
                </c:forEach>
            </select>
            </td>
    </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="恢复"></td>
        </tr>

    </table>
</form>
</body>
</html>
