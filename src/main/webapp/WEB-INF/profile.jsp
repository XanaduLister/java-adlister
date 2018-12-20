<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<%--<c:choose>--%>
    <%--<c:when test = >--%>
        <jsp:include page="/WEB-INF/partials/profile_navbar.jsp" />
    <%--</c:when>--%>

    <%--<c:otherwise>--%>
        <%--<jsp:include page="/WEB-INF/partials/navbar.jsp" />--%>
    <%--</c:otherwise>--%>
<%--</c:choose>--%>


    <div class="container">
        <h1 class="text-center">Welcome <label class="text-success">${sessionScope.user.username}</label> to your closet of curiosities!</h1>
        <form action="/profile/update" method="get">
            <button type="submit" class="btn btn-success btn-block btn-lg">Update Profile</button>
        </form>
        <div class="row">
            <div class="col-12 text-center">
                <label class="customfont fontSize32 text-warning">My Posts</label>
            </div>
        </div>
        <div class="row">
            <c:forEach var="userAds" items="${userAds}">
                <div class="col-6 col-lg-3">
                    <h2>${userAds.title}</h2>
                    <p>${userAds.description}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
