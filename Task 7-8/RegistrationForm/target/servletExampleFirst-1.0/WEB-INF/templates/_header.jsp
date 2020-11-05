<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MySite</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>">
</head>
<body>
<nav class="top">
    <ul>
        <li><a href="<c:url value="/main"/>">Main page</a></li>
        <c:if test="${empty user}">
            <li><a href="<c:url value="/signin"/>">Sign In</a></li>
        </c:if>
        <c:if test="${empty user}">
            <li><a href="<c:url value="/registration"/>">Register</a></li>
        </c:if>
        <c:if test="${not empty user}">
            <li><a href="<c:url value="/profile"/>">Profile</a></li>
            <li><a href="<c:url value="/signout"/>">Sign Out</a></li>
        </c:if>
    </ul>
</nav>
<div class="contents">
