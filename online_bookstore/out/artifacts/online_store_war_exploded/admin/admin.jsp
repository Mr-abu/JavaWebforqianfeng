
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--图书板块--%>
    <a href="${pageContext.request.contextPath}/admin/addBook.jsp">新增图书</a>✔<br>
    <a href="#">更改图书</a><br>
    <a href="#">删除图书</a><br>
    <a href="#">查询图书</a><br>
<%--用户板块--%>
    <a href="${pageContext.request.contextPath}/adminServlet?op=listUsers">查询用户</a>✔<br>
    <a href="#">更改用户</a><br>
    <a href="#">删除用户</a><br>
<%--分类模块--%>
<a href="#">添加分类</a><br>
<a href="#">查询分类</a><br>
<a href="#">根据分类名称查询该分类是否可用</a><br>
<a href="#">删除分类</a><br>
<a href="#">根据分类id查询分类信息</a><br>
</body>
</html>
