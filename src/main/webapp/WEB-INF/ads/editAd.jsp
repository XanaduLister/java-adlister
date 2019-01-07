<%--
  Created by IntelliJ IDEA.
  User: joaquinsilva
  Date: 1/6/19
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Your Ad" />
    </jsp:include>
    <style>
        <%@include file="../partials/css/login.css"%>
        <%@include file="../partials/css/navbar.css"%>
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/profile_navbar.jsp" />
<div class="container">
    <h1 class="text-center customfont fontSize32 text-warning">Edit Your Ad</h1>
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert"><h4>${error}</h4></div>
        <hr class="mb-5">
    </c:if>
    <form action="/ads/edit" method="post">
        <div class="form-group group btn-group-lg input-group-lg">
            <label class="labelSize" for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
        </div>
        <div class="form-group labelSize">
            <label for="category">Categories</label>
            <select class="form-control labelSize" id="category" name="category">
                <optgroup class="labelSize" label="categories">
                    <option value="" selected disabled hidden>Reselect your Category</option>
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
            <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
        </div>
        <button type="submit" class="btn btn-block btn-success btn-lg" name="editAd" value="${editAd}" >Submit Your Changes!
        </button>
    </form>
</div>
</body>
</html>