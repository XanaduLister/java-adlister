<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
    <style>
        <%@include file="../partials/css/login.css"%>
        <%@include file="../partials/css/navbar.css"%>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/profile_navbar.jsp" />
    <div class="container">
        <h1 class="text-center customfont fontSize32 text-warning">Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group group btn-group-lg input-group-lg">
                <label class="labelSize" for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group labelSize">
                <label for="category">Categories</label>
                <select class="form-control labelSize" id="category" name="category">
                    <optgroup class="labelSize" label="categories">
                        <option class="labelSize">computers</option>
                        <option class="labelSize">guitars</option>
                        <option class="labelSize">furniture</option>
                        <option class="labelSize">bicycles</option>
                        <option class="labelSize">services</option>
                        <option class="labelSize">activity</option>
                        <option class="labelSize">dating</option>
                        <option class="labelSize">rentals</option>
                        <option class="labelSize">massage</option>
                        <option class="labelSize">general</option>
                    </optgroup>
                </select>
            </div>
            <div class="form-group">
                <label class="labelSize" for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <button type="submit" class="btn btn-block btn-success btn-lg">Create Ad</button>
        </form>
    </div>
</body>
</html>
