<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
    <style>
        <%@include file="partials/css/login.css"%>
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 class="text-center">Please Log In</h1>
        <form action="/login" method="POST">
            <div class="form-group group btn-group-lg input-group-lg">
                <label class="labelSize" for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-success btn-block btn-lg" value="Log In">
        </form>
        <form action="/register">
            <input type="submit" class="btn btn-success btn-block btn-lg" value="Register">
        </form>
    </div>
</body>
</html>
