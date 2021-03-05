<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/adminServlet?op=getOneUser">
            <table>
                <tbody>
                <tr>
                    <td width="90" align="right">用户名称：</td>
                    <td>
                        <input type="text" name="text" class="" placeholder="请输入搜索内容">
                    </td>
                    <td width="85" align="right" >
                        <input type="submit" class="" value="查询">
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

    <table>
        <c:forEach items="${userPage.userRecords}" var="user">
            <tr>
                <td>用户名：</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>

    <%@ include file="/common/userPage.jsp"%>
</body>
</html>
