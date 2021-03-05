<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<html>
<head>
  <title>Title</title>
</head>

<body>



<div>
  <form action="">
    <table>
      <tbody>
      <tr>
        <td width="90" align="right">书本名称：</td>
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
  <%--            <tr>--%>
  <%--                <th width="20%">商品</th>--%>
  <%--                <th width="40%">商品名称</th>--%>
  <%--                <th width="20%">价格</th>--%>
  <%--                <th width="50px">买买买</th>--%>
  <%--            </tr>--%>

  <sf:forEach items="${listBook}" var="book">
    <div class="book">
      <div class="bookImg">
        <img alt="" src="${pageContext.request.contextPath}/image/故事主角下班后.jpg" width="102">
      </div>
      <div class="">
        <span>书名：${book.name}</span><br/>
        <span>售价：${book.price}</span>
      </div>
    </div>

  </sf:forEach>

</table>


</body>
</html>
