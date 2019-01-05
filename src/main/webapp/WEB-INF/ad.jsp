<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/partials/head.jsp">
		<jsp:param name="title" value="Ad" />
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
</body>
</html>
