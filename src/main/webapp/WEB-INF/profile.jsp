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
        <h1>Welcome, <label class="text-success">${sessionScope.user.username}</label>, to your closet of curiosities!</h1>
        <form action="/profile/update" method="get">
            <button type="submit" class="btn btn-success btn-block btn-lg">Update Profile</button>
        </form>
    </div>

</body>
</html>
