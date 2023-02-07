<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<c:url var="context" value="/" />
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<a href="${context }session/login">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="${context }session/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
