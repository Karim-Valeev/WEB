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
<form:form method="POST" modelAttribute="user">
    <form:label path="userName">userName</form:label>
    <form:input path="userName"/>
    <form:errors path="userName" /><br>

    <form:label path="email">email</form:label>
    <form:input path="email"/>
    <form:errors path="email" /><br>

    <form:label path="password">password</form:label>
    <form:input type="password" path="password"/>
    <form:errors path="password"/><br>

    <form:label path="bio">bio</form:label>
    <form:input type="text" path="password"/>
    <form:errors path="password"/><br>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
