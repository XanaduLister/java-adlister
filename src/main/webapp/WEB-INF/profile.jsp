<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1 class="text-center">Welcome, <label class="text-success">${sessionScope.user.username}</label>, to your closet of curiosities!</h1>
        <form action="/profile/update" method="get">
            <button type="submit" class="btn btn-success btn-block btn-lg">Update Profile</button>
        </form>
        <div class="row">
            <c:forEach var="ad" items="${ads}">
                <div class="col-6 col-lg-3">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                </div>
            </c:forEach>
        </div>
    </div>

</body>
</html>
