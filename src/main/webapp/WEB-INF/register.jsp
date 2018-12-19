<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
    <style>
        <%@include file="partials/css/login.css"%>
    </style>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1 class="text-center">Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-success btn-block btn-lg">
        </form>
    </div>
</body>
</html>
