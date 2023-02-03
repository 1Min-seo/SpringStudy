<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<c:url var="contextRoot" value="/" />
	<a href="${contextRoot }index">인덱스</a>
	<a href="${contextRoot }login">로그인</a>
	<a href="${contextRoot }register">회원가입</a>
	<a href="${contextRoot }board">게시판</a>
</body>
</html>
