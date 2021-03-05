<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/insertBook" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>原书名(英文名)：</td>
                <td>
                    <input name="original_name" id="original_name" />
                </td>
            </tr>
            <tr>
                <td>书名：</td>
                <td>
                    <input name="name" id="name" />
                </td>
            </tr>

            <tr>
                <td>作者：</td>
                <td>
                    <input name="author" id="author" />
                </td>
            </tr>
            <tr>
                <td>译者：</td>
                <td>
                    <input name="translator" id="translator" />
                </td>
            </tr>
            <tr>
                <td>出版社：</td>
                <td>
                    <input name="publishing_house" id="publishing_house" />
                </td>
            </tr>
            <tr>
                <td>isbn：</td>
                <td>
                    <input name="isbn" id="isbn" />
                </td>
            </tr>
            <tr>
                <td>原价：</td>
                <td>
                    <input name="original_price" id="original_price" />
                </td>
            </tr>
            <tr>
                <td>单价：</td>
                <td>
                    <input name="price" id="price" />
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
                    <textarea rows="3" cols="38" name="description"></textarea>
                </td>
            </tr>
            <tr>
                <td>所属分类：</td>
                <td>
                    <select name="classId">
                        <c:forEach items="${sessionScope.cl}" var="c">
                            <option value="${c.id}">${c.classname}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="添加"/>
        <input type="reset" value="重置">
    </form>
</body>
</html>
