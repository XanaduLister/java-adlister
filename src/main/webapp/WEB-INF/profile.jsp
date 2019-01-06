<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <style>
        <%@include file="partials/css/navbar.css"%>
        body {
            background-color: lightgrey;
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.user.username != null}">
        <jsp:include page="/WEB-INF/partials/profile_navbar.jsp" />
    </c:when>

    <c:otherwise>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    </c:otherwise>
</c:choose>

    <div class="container">
        <c:if test="${error != null}">
            <div class="alert alert-danger" role="alert"><h4>${error}</h4></div>
            <hr class="mb-5">
        </c:if>
        <h1 class="text-center">Welcome <label class="text-success">${sessionScope.user.username}</label> to your closet of curiosities!</h1>
        <form action="/profile/update" method="get">
            <button type="submit" class="btn btn-success btn-block btn-lg">Update Profile</button>
        </form>
        <div class="row">
            <div class="col-12 text-center">
                <label class="customfont fontSize32 text-warning">My Ads</label>
            </div>
        </div>
        <div class="row">
            <c:forEach var="userAd" items="${userAds}">
                <div class="col-6 col-lg-4 card card-body pb-0">
                    <div class="row">
                        <div class="col-10">
                            <h1>${userAd.title}</h1>
                        </div>
                        <div class="col-2">
                            <form class="float-right mt-2" action="ads/ad" method="post">
                                <a class="btn btn-success btn-lg" name="info" href="${pageContext.request.contextPath}/ads/ad?id=${ad.id}">Info</a>
                            </form>
                        </div>
                    </div>
                            <h1>${userAd.id}</h1>
                            <a class="fontSize16">${userAd.description}</a>
                    <div class="row card-footer">
                        <div class="col-6">
                            <form class="mt-2" action="ads/edit" method="post">
                                <a class="btn btn-info btn-lg" name="edit" href="${pageContext.request.contextPath}/ads/edit?id=${user_ads.id}">Edit</a>
                            </form>
                            <%--Change all to buttons--%>
                        </div>
                        <div class="col-6">
                            <form class="float-right mt-2" action="ads/delete" method="post">
                                <button class="btn btn-danger btn-lg" name="delete"
                                        value="${userAd.id}">Delete
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
