<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup</title>
	<c:if test="${cookie.quiz.name=='quiz' }">
		<script>window.close();</script>
	</c:if>
</head>
<body>
	<c:url var="context" value="/" />
	<h3>쿠키의 데이터 접근하기</h3>
	<h4>쿠키 중 cookieName의 이름 : ${cookie.quiz.name }</h4>
	<h4>쿠키 중 cookieName의 값 : ${cookie.quiz.value }</h4>
	<input type="checkbox" onclick="location.href='${context}cookie/make'"> 30초 동안 닫기
</body>
</html>
