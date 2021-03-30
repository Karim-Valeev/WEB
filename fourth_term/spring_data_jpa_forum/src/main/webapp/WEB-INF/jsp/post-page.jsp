<%--
  Created by IntelliJ IDEA.
  User: pain
  Date: 15.03.2021
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <div>
        Text: ${text}
    </div>
    <br>

    <c:forEach var="post" items="${posts}">
        <c:choose>
            <c:when test="${post.title != title}">
                <a href="<c:url value="post/${post.title}"/>">${posts.indexOf(post)}</a>
            </c:when>
            <c:otherwise>
                <div>
                    ...
                </div>
            </c:otherwise>
        </c:choose>
    </c:forEach>

</body>
</html>
