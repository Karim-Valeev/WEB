<%--
  Created by IntelliJ IDEA.
  User: pain
  Date: 25.02.2021
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Headers</title>
</head>
<body>
    <div style="border: black 10px solid">
        <c:forEach items="${map}" var="entity">
            <p>${entity.key}=${entity.value}</p>
        </c:forEach>
    </div>
</body>
</html>
