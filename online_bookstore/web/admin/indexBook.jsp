<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>原书名(英文名)</th>
        <th>书名</th>
        <th>作者</th>
        <th>译者</th>
        <th>出版社</th>
        <th>isbn</th>
        <th>原价</th>
        <th>单价</th>
        <%--        <th>图片</th>--%>
        <th>描述</th>
        <th>所属分类</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${page.records}" var="book">
        <tr>
            <td>${book.original_name}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.translator}</td>
            <td>${book.publishing_house}</td>
            <td>${book.isbn}</td>
            <td>${book.original_price}</td>
            <td>${book.price}</td>
            <td>${book.description}</td>
            <td>${book.class_Id}</td>
            <td><a href="${pageContext.request.contextPath}/getOne?id=${book.id}">修改</a>&nbsp;&nbsp;<a href="#">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
