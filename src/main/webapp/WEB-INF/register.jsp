<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${error != null}">
            <div class="alert alert-danger" role="alert"><h4>${error}</h4></div>
            <hr class="mb-5">
        </c:if>
        <h1 class="text-center">Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text"
                       placeholder="e.g., CodyisCurious">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text"
                       placeholder="e.g., Cody@interwebs.com">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password"
                       placeholder="e.g., ***********">
                <h5><strong>Must be greater than 7 characters in length, contain 1 Uppercase letter, 1 Lowercase letter, 1 Digit, and 1
                    Special character...</strong></h5>
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control"
                       type="password" placeholder="e.g., **********">
            </div>
            <input type="submit" class="btn btn-success btn-block btn-lg">
        </form>
    </div>
</body>
</html>
