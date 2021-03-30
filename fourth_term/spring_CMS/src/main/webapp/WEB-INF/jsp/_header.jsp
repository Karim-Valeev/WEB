<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- To throw exceptoins and their stacktrace if smth wrong in jsp --%>
<%--<%@ page errorPage ="errors/test_error.jsp"%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MyFoods</title>

    <meta name="viewport" content="width=device-width,initial-scale=1">

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/profile.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/items.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/header_and_footer.css"/>">

    <script src="<c:url value="/js/favourite.js"/>"></script>
    <script src="<c:url value="/js/from_to_validator.js"/>"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

<%--    TinyMCE skripts--%>
    <script src="https://cdn.tiny.cloud/1/ibd1eml7eya6hjegfz21a4xm13m0szduk5sp6sxp0fssdrym/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

<%--    Bootstrap customizations--%>
    <script>
        tinymce.init({
            selector: 'textarea#editor',
            skin: 'bootstrap',
            plugins: 'lists, link, image, media',
            toolbar: 'h1 h2 bold italic strikethrough blockquote bullist numlist backcolor | link image media | removeformat help',
            menubar: false
        });
    </script>

</head>
<body>

    <div class="nav">
        <div class="pic">
            <img src="<c:url value="/static/img/header/download.png"/>" alt="rus" align="center" width="30" height="40"/>
        </div>

        <div class="center">
            <a class="main-title-link" style="text-decoration: none" href="<c:url value="/"/>">
                My CMS
            </a>
        </div>

        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Hierarchy
            </button>
<%--            Todo заполнение всего этого говна ссылками--%>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <c:forEach var="website" items="${hierarchy}">
                    <a class="dropdown-item"  href="<c:url value="websites/${website.url}"/>">${website.url}</a>
                    <c:choose>
                        <c:when test="${website.children != null}">
                            <c:forEach var="child-website" items="${website.children}">
                                <br>
                                <a class="dropdown-item"  href="<c:url value="websites/${child-website.url}"/>">${child-website.url}</a>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </div>



<%--        <c:choose>--%>
<%--            <c:when test="${hierarchy != null}">--%>
<%--                <c:forEach var="website" items="${hierarchy}">--%>
<%--                    <a class="dropdown-item"  href="<c:url value="websites/${website.url}"/>">${website.url}</a>--%>
<%--                </c:forEach>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                  Empty yet--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>

    </div>



