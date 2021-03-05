<%@ page import="com.book.www.entity.User" %>
<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .book{
            float: left;
            width: 25%;
            text-align: center;
            padding:10px 0px;
        }
        .bookImg img{
            width: 130px;
            height: 196px;
        }
    </style>

    <style type="text/css">
        .top{
            /* 设置宽度高度背景颜色 */
            height: auto; /*高度改为自动高度*/
            width:100%;
            margin-left: 0;
            background:rgb(189, 181, 181);
            position: fixed; /*固定在顶部*/
            top: 0;/*离顶部的距离为0*/
            margin-bottom: 5px;
        }
        .top ul{
            /* 清除ul标签的默认样式 */
            width: auto;/*宽度也改为自动*/
            list-style-type: none;
            white-space:nowrap;
            overflow: hidden;
            margin-left: 5%;
            /* margin-top: 0;          */
            padding: 0;

        }
        .top li {
            float:left; /* 使li内容横向浮动，即横向排列  */
            margin-right:2%;  /* 两个li之间的距离*/
            position: relative;
            overflow: hidden;
        }

        .top li a{
            /* 设置链接内容显示的格式*/
            display: block; /* 把链接显示为块元素可使整个链接区域可点击 */
            color:white;
            text-align: center;
            padding: 3px;
            overflow: hidden;
            text-decoration: none; /* 去除下划线 */

        }
        .top li a:hover{
            /* 鼠标选中时背景变为黑色 */
            background-color: #111;
        }
        .top ul li ul{
            /* 设置二级菜单 */
            margin-left: -0.2px;
            background:rgb(189, 181, 181);
            position: relative;
            display: none; /* 默认隐藏二级菜单的内容 */

        }
        .top ul li ul li{
            /* 二级菜单li内容的显示 */

            float:none;
            text-align: center;
        }
        .top ul li:hover ul{
            /* 鼠标选中二级菜单内容时 */
            display: block;
        }
        body{
            background:#eff3f5;
        }

    </style>

</head>
<body>

<div class="top">
    <center>
        <ul>
            <li><a href="#">一级菜单</a></li>
            <li><a href="#">一级菜单</a></li>
            <li><a href="#">一级菜单</a></li>
            <li><a href="#"><b>一级菜单</b></a></li>
            <li><a href="#">一级菜单</a></li>
            <li>
                <a href="#">一级菜单</a>
                <ul>
                    <li><a href="#">二级菜单</a></li>
                    <li><a href="#">二级菜单</a></li>
                </ul>
            </li>
        </ul>
    </center>
</div>


<div align="center">
    <span style="font-family: 楷体; font-size: x-large; ">欢迎用户：${user.username}</span>
</div>

<div align="center">
    <a href="${pageContext.request.contextPath}/logout">注销登录</a>
</div>
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
