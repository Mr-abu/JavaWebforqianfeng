<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/updateBook" method="post">
<table>
    <tr>
        <td>原书名:</td>
        <td>
            <input name="original_name" value="${book.original_name}" id="original_name" />
        </td>
    </tr>
    <tr>
        <td>书名：</td>
        <td>
            <input name="name" value="${book.name}" id="name" />
        </td>
    </tr>

    <tr>
        <td>作者：</td>
        <td>
            <input name="author" value="${book.author}" id="author" />
        </td>
    </tr>
    <tr>
        <td>译者：</td>
        <td>
            <input name="translator"value="${book.translator}" id="translator" />
        </td>
    </tr>
    <tr>
        <td>出版社：</td>
        <td>
            <input name="publishing_house"value="${book.publishing_house}" id="publishing_house" />
        </td>
    </tr>
    <tr>
        <td>isbn：</td>
        <td>
            <input name="isbn"value="${book.isbn}" id="isbn" />
        </td>
    </tr>
    <tr>
        <td>原价：</td>
        <td>
            <input name="original_price"value="${book.original_price}" id="original_price" />
        </td>
    </tr>
    <tr>
        <td>单价：</td>
        <td>
            <input name="price"value="${book.price}" id="price" />
        </td>
    </tr>
    <tr>
        <td>图片：</td>
        <td>
            <input type="file" name="image" />
        </td>
    </tr>
    <tr>
        <td>描述：</td>
        <td>
            <textarea rows="3" cols="38" value="${book.description}" name="description"></textarea>
        </td>
    </tr>
    <tr>
        <td>所属分类：</td>
        <td>
            <select name="classId">
                <c:forEach items="${sessionScope.allClass}" var="c">
                    <option value="${c.id}"
                    <c:if test="${book.class_Id==c.id}">
                        selected;
                    </c:if>
                    ${c.classname}>
                    </option>
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
