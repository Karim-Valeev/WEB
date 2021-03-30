<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<a href="<c:url value="/" />">Homepage</a><br><br>
<c:if test="${not empty message}">
    <h1>${message}</h1>
</c:if>
<div style="text-align: center; font-size: 30px">
    TEST
</div>

<form action="<c:url value="register"/>" method="POST">
    <div>
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" placeholder="User name" required value="${name}">
    </div>
    <div>
        <label for="name">Email:</label>
        <input type="text" name="name" id="name" placeholder="Basket name" required value="${name}">
    </div>
    <div>
        <label for="name">Password:</label>
        <input type="text" name="name" id="name" placeholder="Basket name" required value="${name}">
    </div>
    <div>
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" placeholder="Basket name" required value="${name}">
    </div>
    <div>
        <input type="submit" value="Register">
    </div>
</form>

<%--<form:form method="POST" modelAttribute="user">--%>
<%--    <form:label path="userName">userName</form:label>--%>
<%--    <form:input path="userName"/>--%>
<%--    <form:errors path="userName" /><br>--%>

<%--    <form:label path="email">email</form:label>--%>
<%--    <form:input path="email"/>--%>
<%--    <form:errors path="email" /><br>--%>

<%--    <form:label path="password">password</form:label>--%>
<%--    <form:input type="password" path="password"/>--%>
<%--    <form:errors path="password"/><br>--%>

<%--    <form:label path="bio">bio</form:label>--%>
<%--    <form:input type="text" path="password"/>--%>
<%--    <form:errors path="password"/><br>--%>

<%--    <input type="submit" value="Submit"/>--%>
<%--</form:form>--%>
</body>
</html>
