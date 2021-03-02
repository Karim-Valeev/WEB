<%--
  Created by IntelliJ IDEA.
  User: walai_kami
  Date: 12/10/2020
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>">

    <script src="../../static/js/script.js"></script>

    <title>Registration</title>
</head>
<body class="color">

<form action="registration" method="POST">
    <div class="mid">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" placeholder="Login" required>
    </div>
    <div class="mid">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" placeholder="Email" required>
    </div>
    <div class="mid">
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" placeholder="Password" required>
    </div>
    <div class="mid">
        <label for="conf-password">Confirm password:</label>
        <input type="password" name="conf-password" id = "conf-password" placeholder="Confirm password" required>
    </div>
    <div class="mid">
        <input type="checkbox" id="agreement" name="agreement" required>
        <label for="agreement">I agree with terms conditions and privacy policy</label>
    </div>
    <div class="mid">
        <input type="submit" >
    </div>
</form>

</body>
</html>
