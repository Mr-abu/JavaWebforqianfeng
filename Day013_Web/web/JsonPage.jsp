
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="div1">
        填充数据
    </div>
<button onclick="changes()">
    填充对象
</button>
    <script type="text/javascript">
        function changes() {
            var xhr = new XMLHttpRequest();

            xhr.onreadystatechange= function (ev) {
                if (xhr.readyState==4 && xhr.status==200) {
                    //接收服务器发送的JSON数据
                    var s = xhr.responseText;
                    //通过内置对象将JSON字符串转换为对象
                    var obj = JSON.parse(s);
                    //填充数据  DOM操作
                    document.getElementById("div1").innerText = s;
                }
            }

            xhr.open("get","${pageContext.request.contextPath}/js", true);
            xhr.send();
        }
    </script>
</body>
</html>
