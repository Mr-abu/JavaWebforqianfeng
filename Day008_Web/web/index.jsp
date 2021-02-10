<%@ page import="com.qf.www.entity.User" %>
<%@ page import="com.qf.www.entity.Address" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    //El表达式可以简化作用域取值，获得属性值
    request.setAttribute("name","aqiang");
    session.setAttribute("name1","admin");
    application.setAttribute("name2","users");
    User user = new User(1,"aqiang","123456","13133832499",1, new Address("北京", "100000"));
    request.setAttribute("users", user);
  %>
  <%=request.getAttribute("name")%><br>
  <%=pageContext.findAttribute("name")%><br>

<%--  El表达式写法，不用写作用域， 从小到大查找--%>
  ${name}<br>
  ${name1}<br>
  ${"name2"}<br>
  ${users}
  ${users.getUsername()}<br>
  ${users.username}<br>
  ${users.address}<br>
  ${users.address.name}<br>

<%--  如果4个作用域都重名， 想拿Session里的，指定作用域--%>
  ${sessionScope.name1}

  </body>
</html>
