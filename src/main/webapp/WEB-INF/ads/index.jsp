<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <div class="row">
        <div class="col-12 text-center">
            <label class="customfont fontSize32 text-warning">All Ads</label>
        </div>
    </div>

    <div class="row">
        <c:forEach var="ad" items="${ads}">
            <div class="col-6 col-lg-3 adsBorder">
                <h2>${ad.title}</h2>
                <hr />
                <p class="fontsize14">${ad.description}</p>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
