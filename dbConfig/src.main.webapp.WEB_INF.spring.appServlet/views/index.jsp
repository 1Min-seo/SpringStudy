<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style>
	a{text-decoration:none; color:black}
</style>
</head>
<body>
	<c:url var="contextRoot" value="/" />
	<a href="${contextRoot }index">인덱스</a> |
	<c:choose>
			<%--세션의 값에 따라 로그인 여부를 알 수 있다. --%>
		<c:when test="${ empty sessionScope.id }">
			<a href="${contextRoot }login">로그인</a> |
			<a href="${contextRoot }register">회원가입</a> |
			<a href="${contextRoot }board">게시판</a>
		</c:when>
		<c:otherwise>
			<a href="${contextRoot }logout">로그아웃</a> |
			<a href="${contextRoot }list">회원목록</a> |
			<a href="${contextRoot }update">회원수정</a> |
			<a href="${contextRoot }delete">회원삭제</a> |
		</c:otherwise>
	</c:choose>
	

</body>
</html>
