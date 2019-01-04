<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ page import="com.codeup.adlister.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Retal
  Date: 12/19/18
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
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
        <form action="/profile/update" method="post">
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="new_password">New Password</label>
                <input id="new_password" name="new_password" class="form-control" type="password">
            </div>
            <div class="form-group btn-group-lg input-group-lg">
                <label class="labelSize" for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <button type="submit" class="btn btn-success btn-block btn-lg">Edit Profile</button>
        </form>
    </div>

</body>
</html>
