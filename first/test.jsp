<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Test
</h1>
<P> The time on the server is ${serverTime}. </P>
<%--제어문 작성시 --%>
<c:if test="${empty id}">
	<p>아이디는 없어요.
</c:if>
<c:if test="${not empty id }">
	<p> 아이디 : ${id}.</p>
</c:if>
<p> 비밀번호 : ${pw}</p>
</body>
</html>
