<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List styles = (List)request.getAttribute("styles");
        Iterator it = styles.iterator();
        while (it.hasNext()) {
            out.print("<br>try: " + it.next());
        }
    %>
</body>
</html>
