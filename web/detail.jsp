<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 20.01.2020
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    User user = (User) request.getAttribute("user");
    out.print("id:  " + user.getId()+ "   name:  " + user.getName() + "   password:  " + user.getPassword());
%>
<form  action="/update" method="post">
    <input type="hidden" name="id" value="<%out.print(user.getId());%>">
    <input type="text" name="name" value="<%out.print(user.getName());%>">
    <input type="text" name="password" value="<%out.print(user.getPassword());%>">
    <button>update</button>
</form>
</body>
</html>
