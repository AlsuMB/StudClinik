<%--
  Created by IntelliJ IDEA.
  User: Алсу
  Date: 01.11.2020
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<%
    // session case
    String user = null;
    String sessionUser = (String) session.getAttribute("username");
    if (sessionUser == null) {
        response.sendRedirect("webapp/login.ftl");
    } else {
        user = sessionUser;
    }


    // cookie case
    String userName = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) userName = c.getValue();
            if (c.getName().equals("JSESSIONID")) sessionId = c.getValue();
        }
    } else {
        sessionId = session.getId();
    }
%>
<h3> Hello, <%=userName%>! Login Successful.
    Session ID=<%=sessionId%>

</h3>
<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
