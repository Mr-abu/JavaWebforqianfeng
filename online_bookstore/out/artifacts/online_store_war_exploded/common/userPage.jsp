<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    第${userPage.pageNum}页/共${userPage.totalPageSize}页 &nbsp;
    <a href="${pageContext.request.contextPath}${userPage.url}&num=1">首页</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}${userPage.url}&num=${userPage.prePageNum}">上一页</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}${userPage.url}&num=${userPage.nextPageNum}">下一页</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}${userPage.url}&num=${userPage.totalPageSize}">尾页</a>&nbsp;&nbsp;

    <select id="jump" onchange="jump(this)"
    <c:forEach begin="1" end="${userPage.totalPageSize}" var="n">

        <option value="${n}" ${userPage.pageNum==n?'selected="selected"':''}>${n}</option>
    </c:forEach>
    </select>

    <input type="text" size="3" id="num"/><input type="button" value="跳转" onclick="jump1()"/>

    <script type="text/javascript">
        function jump(selectObj){
            window.location.href="${pageContext.request.contextPath}${userPage.url}&num="+selectObj.value;
        }
        function jump1(){
            //得到用户输入的页码
            var num = document.getElementById("num").value;
            //alert(num);
            //验证必须是个自然整数
            if(!/^[1-9][0-9]*$/.test(num)){
                alert("请输入正确的页码?");
                return;
            }
            //页码有没有超出范围
            if(num>${userPage.totalPageSize}){
                alert("页码超出范围");
                return;
            }
            window.location.href="${pageContext.request.contextPath}${userPage.url}&num="+num;
        }
    </script>
</div>