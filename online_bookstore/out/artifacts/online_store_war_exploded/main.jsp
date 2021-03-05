<%@ page import="java.io.File" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<html>
<head>
    <title>Title</title>
</head>

<style>
    /* 共有标签去掉内外间距 */
    *{
        margin: 0;
        padding: 0;
    }
    a{
        color: black;
        /* 去掉a标签的样式 */
        text-decoration: none;
    }
    /* 去掉ul，ol的样式 */
    ul,ol{
        list-style: none;
    }
    .goods{
        width: 255px;
        height: 390px;
        border: 1px solid #555753;
    }
    /* 设置图片的大小 */
    .goods>.dd>img{
        width: 250px;
        height: 255px;

    }
    .dd{
        width: 255px;
        height: 255px;
        position: relative;
    }
    .intro{
        width: 255px;
        height: 25px;
        background-color: orange;
        /* 绝对定位，子级绝对点位，父级一定是相对定位 */
        position: absolute;
        left: 0;
        right: 0;
        bottom: -2px;
        /* 本身不出来，当hover的时候才出来 */
        position: absolute;
        display: none;
    }
    .goods>.dd:hover>.intro{
        display:block ;
    }
    .intro-left{
        width: 130px;
        height: 25px;
        float: left;
        line-height:25px ;
        text-align: center;
    }
    .intro-right{
        width: 125px;
        height: 25px;
        float: left;
        line-height:25px ;
        text-align: center;
    }
    .intro-left>a{
        font-weight: bold;
    }
    .intro-right>a{
        font-weight: bold;
    }
    .price{
        color: orange;
        font-size: 20px;
    }
    /* 伪元素 */
    .price::after{
        content:'包邮' ;
        color: orange;
        font-size: 14px;
        display: inline-block;
        margin-left: 6px;
    }
    .count{
        color: black;
        font-size: 14px;
        float: right;
        display: inline-block;
        margin-top:10px;
        margin-right:10px;
    }
    .title>a{
        color: #333;
        font-size: 12px;

    }
    .title>a:hover{
        color: orange;
        text-align: underline;
    }
    p.color{
        color: #999;
    }

</style>

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
        <c:forEach items="${page.records}" var="book">

            <td>
                <div class="goods">
                    <div class="dd">
    <%--                    <h1>${book.path}</h1>--%>
    <%--                    <h1>${book.filename}</h1>--%>
    <%--                    <h1>file:///${book.path}${File.separator}${book.filename}</h1>--%>
                        D:\WorkPlace\online_bookstore\out\artifacts\online_store_war_exploded\WEB-INF\upload\5\15
                        <img src="online_bookstore/out/artifacts/online_store_war_exploded/WEB-INF/upload/5/15/b4363254086a43679c0b95e8e01f7207_s4677623.jpg" alt="这是一个图片">
                        <div class="intro">
                            <div class="intro-left"><a href="">找同款</a></div>
                            <div class="intro-right"><a href="">找相似</a></div>
                        </div>
                        <div>
                            <p>
                                <span class="price">￥${book.price}</span>
                                <span class="count">10万人付款</span>
                            </p>
                            <p class="title color"><a href="#">
                                书名：${book.name}<br>
                                作者：${book.author}<br>
                                售价：${book.price}
                            </a></p>

                        </div>
                    </div>
                </div>
            </td>

        </c:forEach>
    </table>


<%@ include file="/common/page.jsp"%>




</body>
</html>
