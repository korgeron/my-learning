<%--
  Created by IntelliJ IDEA.
  User: kjorgeron0819
  Date: 7/19/22
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/login-form.css">
</head>
<body>
<%@ include file="partials/nav.jsp" %>


<form action="/login" method="POST">
    <formcontent>
        <label for="username">USERNAME</label>
        <br>
        <input type="text" name="username" id="username">
        <br>
        <label for="password">PASSWORD</label>
        <br>
        <input type="password" name="password" id="password">
    </formcontent>
    <formbutton>
        <button type="submit">Login</button>
    </formbutton>
</form>


</body>
</html>
