
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载列表</title>
</head>
<body>
    <h3>下载列表</h3>
    <table>
        <tr>
            <th>文件名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${filenames}" var="file">
            <tr>
                <td>${file.value}</td>
                <td>
                    <a href="">下载</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
