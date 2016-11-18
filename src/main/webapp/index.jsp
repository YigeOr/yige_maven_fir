<%--
  Created by IntelliJ IDEA.
  User: zyk
  Date: 2016/10/21
  Time: 14:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    hello word
    <form action="helloWorld" method="post">
        <input name="name" />
        <input type="submit" value="sumbit"/>

        return : <%=request.getAttribute("name")%>
        return : <%=request.getAttribute("student")%>
    </form>

</body>
</html>
