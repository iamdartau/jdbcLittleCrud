<%@ page import="java.util.ArrayList" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 19.01.2020
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");

    if (users != null) {
        for (User user : users
        ) {
%>
<h1><%=user.getName()%></h1>
<p><%=user.getPassword()%></p>
<form action="/delete" method="post">
    <input type="hidden" name="id" value="<%=user.getId()%>">
    <button>delete</button>
</form>
<a href="detail.jsp?id=" >
<%
out.print("<a href = 'detail?id=" + user.getId() + "'>DETAILS</a>");
        }
    }
%>

<form action="/home" method="post">
    <input name="name" type="text">
    <input name="password" type="password">
    <button>insert</button>
</form>
</body>
</html>
