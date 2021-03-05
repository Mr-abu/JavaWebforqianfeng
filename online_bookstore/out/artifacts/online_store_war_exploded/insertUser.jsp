<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>注册界面</title>
</head>

<body>

    <div id="box">
        <form action="${pageContext.request.contextPath}/insertUser" method="post" name="insertForm">

            用户名称：<Input type=text name="username" required = "true" oninput="usernameChange()">
            <span id="usernameText"></span><br><br>
            收货人：<input type="text" name="realName" required = "true"><br><br>
            收货地址：<input type="text" name="address" required = "true"><br><br>
            联系电话：<input type="text" name="phone" required = "true"><br><br>
            用户邮箱：<input type="text" name="email"><br><br>
            用户密码：<input type="password" name="password" id="pwd1" oninput="passwordChange()">
            <span id="pwdCheck1"></span><br><br>
            重复密码：<Input id="pwd2" type=password name="again_password" onkeyup="pwdCheck()">
            <span id="pwdCheck2"></span><br><br><br>
            <input type="submit" value="提交">
            <input type="reset" value="重新输入">&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/login.jsp">已有账号? 去登录！</a>
            <%--        用户名和密码由3个以上字母、数字、下划线构成，*注释的项必须填写。<br>--%>

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

        function usernameChange() {
            var str = insertForm.username.value;
            var reg = /[a-zA-Z0-9]{4,16}/;
            if (reg.test(str)) {
                usernameText.innerHTML="✔";
                usernameText.style.color="green";
            } else {
                usernameText.innerHTML="✘账号为4位以上规定字符";
                usernameText.style.color="red";
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


        function pwdCheck() {
            var pwd1 = document.getElementById("pwd1").value;
            var pwd2 = document.getElementById("pwd2").value;

            if (pwd1 == pwd2) {
                document.getElementById("pwdCheck1").innerHTML="✔";
                document.getElementById("pwdCheck1").style.color="green";
                document.getElementById("pwdCheck2").innerHTML="✔";
                document.getElementById("pwdCheck2").style.color="green";
                document.getElementById("submit").disabled = false;
            } else {
                document.getElementById("pwdCheck1").innerHTML="✘";
                document.getElementById("pwdCheck1").style.color="red";
                document.getElementById("pwdCheck2").innerHTML="两次密码不相同";
                document.getElementById("pwdCheck2").style.color="red";
                document.getElementById("submit").disabled = true;
            }
        }

    </script>

</body>
</html>
