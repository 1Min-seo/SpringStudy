<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie</title>
</head>
<body>
<c:url var="context" value="/" />
<c:if test="${empty cookie.quiz.name }">
<script>window.open("${context}cookie/popup","","width=500px,height=550px,top=100px,left=200px")</script>
</c:if>
	<h3>쿠키페이지</h3>
	<h3>${context }</h3>
</body>
</html>
