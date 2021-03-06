<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Update your Profile!" />
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
        <form action="/profile/update" method="post">
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="username">Change Username</label>
                <input id="username" name="username" class="form-control" type="text" value="${sessionScope.user.username}">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="email">Change Email</label>
                <input id="email" name="email" class="form-control" type="text" value="${sessionScope.user.email}">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="new_password">New Password</label>
                <input id="new_password" name="password" class="form-control" type="password" placeholder="Enter current password or a new password.">
            </div>
            <button type="submit" class="btn btn-success btn-block btn-lg">Edit Profile</button>
        </form>
    </div>
</body>
</html>
