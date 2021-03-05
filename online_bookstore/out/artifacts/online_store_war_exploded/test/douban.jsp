<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    *{
        padding: 0;
        margin: 0;
        /*font-size: 0;*/
    }
    header{
        width:100%;
        height: 30px;
        background-color: #555753;
    }
    /*顶部导航栏*/
    header li{
        list-style: none;
        line-height: 30px;
    }
    .left-ul li{
        float: left;
    }
    .hang{
        width:100%;
    }
    .hang li{
        width:20%;
        float:left;
    }


    .right-ul{
        float: right;
        margin-right: 164px;
    }
    .right-ul li{
        float: left;
    }
    header a{
        text-decoration: none;
        font-size: 12px;
        padding: 0 12px;
    }
    header a:link{
        color: #ffffff;
    }
    header a:visited{
        color: #ffffff;
    }
    header a:hover{
        font-size: 14px;
        color: #565854;
        background: 48px 30px #ffffff;
    }
    /*banner区域*/
    .banner{
        width:100%;
        height: 75px;
        background-color: #edf4ed;
    }
    .banner01{
        width: 960px;
        height: 75px;
        background-color: #edf4ed;
        margin: auto;
    }
    .banner01 img{
        clear: both;
        display: inline-block;
        float: left;
        margin: 22px 20px ;
    }
    .banner01 li{
        float: left;
        list-style: none;
        padding: 0 11px;
    }
    .banner01 a{
        text-decoration: none;
        font-size: 16px;
        font-weight: 700;
        line-height: 75px;
    }
    .banner01 a:link{
        color: #2b963b;
    }
    .banner01 a:visited{
        color: #2b963b;
    }
    .banner01 a:hover{
        font-size: 18px;
        color: #b53e27;
    }

    .banner01 input{
        display: inline-block;
        float: right;
        width: 260px;
        height: 28px;
        margin: 22.5px 0px;
    }
    .banner01 button img{
        padding-left: 264px;
        margin: 0 0;
    }
    button{
        float: right;
        width: 30px;
        height: 30px;
        margin: 22.5px 0;
        border: none;
        background: none;
    }
    /*内容区*/
    .container{
        clear: both;
        width: 960px;
        margin: auto;
        overflow: hidden;
        /*height: 1000px;*/
        background-color: rgba(255, 169, 40, 0.7);
    }
    /*左半边*/
    .left{
        width:600px;
        background-color: #ffffff;
        height: 100%;
        float: left;
        padding-top: 50px;
    }
    /*搜索框上导航*/
    .leftul li{
        list-style: none;
        float: left;
        padding-right: 18px;
    }
    .leftul a{
        text-decoration: none;
        font-size: 14px;
    }
    .leftul b{
        display: inline-block;
        width: 19px;
        height: 15px;
        /*background-image: url("../img/icon.png");*/
    }
    .leftul li:nth-child(2) b{
        background-position: 0 -16px;
    }
    .leftul li:nth-child(3) b{
        background-position: 0 -33px;
    }
    .leftul li:nth-child(4) b{
        background-position: 0 -50px;
    }
    .leftul li:nth-child(5) b{
        background-position: 0 -67px;
    }
    .leftul a:link{
        color: #1b96ff;
    }
    .leftul a:visited{
        color: #1b96ff;
    }
    .leftul a:hover{
        color: #000000;
    }
    .left p{
        float: right;
        font-size: 12px;
        color: #888888;
    }
    .set a{
        text-decoration: none;
        font-size: 12px;
        color: #888888;
    }
    .left .set a:link{
        color: #888888;
    }
    .left .sett a:visited{
        color: #888888;
    }
    .left .set a:hover{
        text-decoration: underline;
    }
    .left input{
        display: inline-block;
        clear: both;
        width: 596px;
        height: 28px;
    }
    /*相机图标*/
    .camera{
        display: inline-block;
        width: 17px;
        height: 13px;
        border: none;
        margin: -20px 0 0 0;
        /*background-image: url("../img/icon2.png");*/
    }
    .camera img{
        padding: 0px;
        margin: 0 0;
    }
    /*评论区*/
    .pinglun{
        width: auto;
        overflow: hidden;
        padding-top: 24px;
        /*background-color: #1b96ff;*/
    }
    .pinglun a{
        text-decoration: none;
        font-size: 14px;
    }
    .pinglun a:link{
        color: #1b96ff;
    }
    .pinglun a:visited{
        color: #1b96ff;
    }
    .pinglun a:hover{
        color: #000000;
    }
    .pinglun img{
        float: left;
    }
    /*评论区内容*/
    .neirong{
        width: 537px;
        float: right;
        /*background-color: #2b963b;*/
    }
    h1{
        height: 15px;
        font-size: 12px;
        margin-bottom: 12px;
    }
    .gray{
        width: 515px;
        height: 140px;
        padding: 17px 0 17px 20px;
        float: right;
        background-color: #f9f9f9;
    }
    .article{
        width: 338px;
        float: left;
    }
    .article p{
        float: none;
    }
    .article p:nth-child(1){
        margin-bottom: 12px;
    }
    .picture img{
        width: 107px;
        height: 60px;
        float: right;
        padding-top: 10px;
        padding-right: 24px;
    }
    .like{
        display: inline-block;
        width: 52px;
        height: 20px;
        border: 1px solid #aaaaaa;
        margin: 16px 0;
        text-align: center;
        line-height: 20px;
    }
    .like i{
        display:inline-block;
        width: 12px;
        height: 11px;
        /*background-image: url("../img/ic_actions.png");*/
    }
    .like:hover i{
        background-position: 0 -13px;
    }
    .like:hover{
        color: #e03636;
    }
    .neirong .time{
        clear: both;
        float: none;
        text-align: left;
        padding: 10px 0 28px 20px;
        font-size: 10px;
        border-bottom: 1px solid #aaaaaa;
    }
    /*右半边*/
    .right{
        width:260px;
        /*background-color: red;*/
        height: 100%;
        float:right;
    }
    .happen{
        width: 224px;
        height: 78px;
        background-color: #f2f7f6;
        padding: 18px;
        margin-top: 50px;

    }
    /*区块一*/
    .happen{
        margin-bottom: 20px;
    }
    .happen h2{
        font-size: 16px;
        color: #007722;
        margin-bottom: 16px;
    }
    .happen p{
        font-size: 12px;
        color: #3377aa;
        margin-bottom: 14px;
    }
    .happen p a:hover{
        color: #ff5522;
    }
    /*区块二*/
    .adver img{
        width: 260px;
        margin-bottom: 48px;
    }
    /*区块三*/
    .shenqing{
        margin-bottom: 34px;
    }
    .right p a{
        text-decoration: none;
        color: #33a0da;
    }
    .right p a:hover{
        color: #ff5522;
    }
    /*区块四（二维码）*/
    .erweima img{
        width: 260px;
        margin-bottom: 32px;
    }
    /*区块五（热门活动）*/
    .hot{
        height: 120px;
        margin-bottom: 38px;
        /*background-color: #ffffff;*/
    }
    .hot h2{
        font-size: 16px;
        color: #007722;
        margin-bottom: 16px;
    }
    .hot h2 a{
        text-decoration: none;
        font-size: 12px;
        color: #33a0da;
    }
    .hot p{
        font-size: 12px;
        color: #3377aa;
    }
    .hot p:nth-child(4){
        color: #888;
    }
    .hot p:nth-child(5){
        color: #888;
    }
    .hot p:nth-child(6){
        margin-top: 20px;
    }
    .hot img{
        width: 48px;
        float: right;
    }
    /*区块六*/
    .city{
        margin-bottom: 20px;
    }
    .xiamen{
        height: 120px;
        margin-bottom: 15px;
    }
    .city h2{
        font-size: 16px;
        color: #007722;
        margin-bottom: 16px;
    }
    .city h2 a{
        text-decoration: none;
        font-size: 12px;
        color: #33a0da;
    }
    .city div img{
        float: left;
        width: 120px;
        margin-right: 10px;
    }
    .beijing{
        height: 120px;
        margin-bottom: 17px;
    }
    .xiamen p,.beijing p{
        float: left;
        color: #888;
        font-size: 14px;
    }
    .city p{
        float: left;
    }
    .open{
        margin-bottom: 20px;
    }
    /*区块七（灾区儿童）*/
    .unicef{
        clear: both;
        width: 260px;
    }
    /*底部*/
    footer{
        width: 960px;
        height: 45px;
        margin: auto;
        margin-top: 60px;
        border-top: 1px dashed #888888;
    }
    footer p{
        font-size: 12px;
        color: #888888;
        line-height: 45px;
    }
    footer ul{
        float: right;
    }
    footer ul li{
        float: left;
        padding: 0 5px;
    }
    footer ul li:nth-child(1){
        list-style: none;
    }
    footer a{
        text-decoration: none;
        line-height: 45px;
        font-size: 12px;
        color: #33a0da;
    }
</style>
<body>
    <%--  顶部导航栏  --%>
    <header>
<%--        顶部左侧导航--%>
    <ul class="left-ul">
        <li><a href="#">豆瓣</a></li>
        <li><a href="#">文学</a></li>
        <li><a href="#">流行</a></li>
        <li><a href="#">文化</a></li>
        <li><a href="#">生活</a></li>
        <li><a href="#">经管</a></li>
        <li><a href="#">科技</a></li>
<%--        <li><a href="#">F44</a></li>--%>
<%--        <li><a href="#">东西</a></li>--%>
<%--        <li><a href="#">集市</a></li>--%>
<%--        <li><a href="#">更多</a></li>--%>
    </ul>
<%--        右侧导航--%>
    <ul class="right-ul">
        <li><a href="#">${user.username}的账号</a></li>
        <li><a href="#">个人主页</a></li>
        <li><a href="#">我的订单</a></li>
        <li><a href="#">我的钱包</a></li>
        <li><a href="#">账号管理</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
    </ul>

    </header>

<%--&lt;%&ndash;顶部下&ndash;%&gt;--%>
<%--    <div class="banner">--%>
<%--&lt;%&ndash;        <div class="huamg">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <img src="../img/banner.png" alt="豆瓣网"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <ul class="hang">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#">首页</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#">我的豆瓣</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#">浏览发现</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#">移动应用</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <!--<li><a href="#">游戏</a></li>-->&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><a href="#">线上活动</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </ul>&ndash;%&gt;--%>
<%--            <form action="">--%>
<%--                <input type="text" placeholder="搜索你感兴趣内容和人"/>--%>
<%--                <button>--%>
<%--                    <img src="../img/mirror.png" alt=""/>--%>
<%--                </button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--下面的底部--%>
    <footer>

        <a href="#">关于豆瓣</a>
        <a href="#">在豆瓣的工作</a>
        <a href="#">联系我们</a>
        <a href="#">免责声明</a>
        <a href="#">帮助中心</a>
        <a href="#">移动应用</a>
        <a href="#">豆瓣广告</a>

        <p>&copy2005-2016 douban.com,all rights reserved 北京豆网科技有限公司</p>
    </footer>
</body>
</html>
