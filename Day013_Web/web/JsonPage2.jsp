
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button onclick="sendJson()">发送JSON给服务器</button>
    <script type="text/javascript">
        function sendJson() {
            var xhr = new XMLHttpRequest();

            xhr.onreadystatechange = function (ev) {
                if (xhr.readyState == 4 && xhr.status == 200){
                    document.write(xhr.responseText)
                }
            }
            var json = "{'id':1, 'name':'JAVAEE-1910', 'students':[{'id':101, 'name':'刘艺', 'age':16},{'id':102, 'name':'小李', 'age':22}]}";
            xhr.open("get","${pageContext.request.contextPath}/js2?json="+encodeURIComponent(json, "utf-8"),true);
            xhr.send();
        }
    </script>
</body>
</html>
