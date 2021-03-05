<%@ include file="../header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="box">
        <form action="${pageContext.request.contextPath}/adminLogin" method="post" name="loginForm">
            管理员名称：&nbsp;<input type="text" name="administrator" oninput="administratorChange()">
            <span id="administratorText"></span><span id="loginInfo"></span><br><br>
            请输入密码：&nbsp;<input type="password" name="password" oninput="passwordChange()">
            <span id="passwordText"></span><br><br>
            验证码：&nbsp;&nbsp;&nbsp;<input tylpe="text" name="validate" size="10" oninput="validate()">
            <img name="imgValidate" onclick="refresh()" border="0" src="${pageContext.request.contextPath}/validate"><br>
            <span id="codeText" name = "codeText" style="color: green"></span><br><br>
            <input type="submit" value="登录">
            <input type="reset" value="重新输入">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.jsp">点这！返回普通用户登录</a>
            <%--    <input type="checkbox" name="remember" id="remember">记住密码&nbsp;<input type="checkbox" name="autoLogin" id="autoLogin">自动登录<br><br>--%>
            <%--    <a href="${pageContext.request.contextPath}/insertUser.jsp">没有账号? 点这里，去注册！</a><a href="${pageContext.request.contextPath}/adminLogin.jsp">管理员登录</a><br>--%>
        </form>
    </div>

    <style>
        #box{
            /*overflow: auto;*/
            /*margin: auto;*/
            /*position: absolute;*/
            /*top: 0;*/
            /*left: 0;*/
            /*right: 0;*/
            /*bottom: 0;*/
            width: 400px;
            height: 200px;
            /*background: #ccc;*/
            position:absolute;
            left:50%;
            margin-left:-200px;
            top:50%;
            margin-top:-100px;
        }
    </style>
    <script type="text/javascript">

        function administratorChange() {
            var str = loginForm.administrator.value;
            var reg = /[a-zA-Z0-9]{4,16}/;
            if (reg.test(str)) {
                administratorText.innerHTML="✔";
                administratorText.style.color="green";
            } else {
                administratorText.innerHTML="✘账号为4位以上规定字符";
                administratorText.style.color="red";
            }
        }

        function passwordChange() {
            var str = loginForm.password.value;
            var reg = /^[x00-x7f]+$/;
            if (reg.test(str)&&str.length>4&&str.length<17){
                passwordText.innerHTML="✔";
                passwordText.style.color="green";
            } else {
                passwordText.innerHTML="✘密码是4位以上字符";
                passwordText.style.color="red";
            }
        }

        function refresh() {
            loginForm.imgValidate.src="${pageContext.request.contextPath}/validate?n="+Math.random();
            //loginForm.imgValidate.src="validate.jsp"+"?d"+Math.random();
        }
    </script>
</body>
</html>
