<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/_header.jsp" %>

    <div style="font-size: 30px; color: blue">
        Adminka
    </div>
    <br>
    <div>
        WYSIWYG
    </div>

<form action="<c:url value="/adminka"/>" method="post">
    <div class="container mt-4 mb-4">
        <div class="row justify-content-md-center">
            <div class="col-md-12 col-lg-8">
                <h1 class="h2 mb-4">Create your own simple website!</h1>

                <label>Title:</label>
                <div>
                    <input type="text" name="title" class="form-control" style="width:100%"  placeholder="Enter title here"/>
                </div>

                <label>Parent url:</label>
                <div>
                    <input type="text" name="parent_url" class="form-control" style="width:100%"  placeholder="Enter parent url here"/>
                </div>

                <%--                <label>Describe the issue in detail</label>--%>
                <div class="form-group">
                    <textarea name="html_body" id="editor"></textarea>
                </div>

<%--                <input type="submit" value="Save"/>--%>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </div>
</form>



<%@include file="/WEB-INF/jsp/_footer.jsp" %>
