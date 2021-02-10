<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        request.setAttribute("list",list);

        Set<String> stringSet = new HashSet<String>();
        stringSet.add("A");
        stringSet.add("B");
        stringSet.add("C");
        stringSet.add("D");
        request.setAttribute("stringSet", stringSet);

        Map<String, String> maps = new HashMap<String, String>();
        maps.put("CN", "中国");
        maps.put("JP", "日本");
        maps.put("UK", "英国");
        maps.put("US", "美国");
        request.setAttribute("maps", maps);
    %>
    <%=list.get(0)%><br>

    ${list[0]}<br>
    ${list.get(0)}<br>

    ${stringSet}<br>

    ${maps.get("CN")}<br>
    ${maps.CN}<br>
    ${maps.keySet()}<br>
    ${maps.values()}<br>


</body>
</html>
