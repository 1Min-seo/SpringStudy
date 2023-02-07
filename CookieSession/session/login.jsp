<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<!-- http://localhost:8085/cs/session/login -->
	<c:url var="context" value="/" />
	<h3> ${msg }</h3>
	<form action="${context}session/login" method="post">
		<input type="text" name="id" placeholder="아이디" /><br>
		<input type="password" name="pw" placeholder="비밀번호" /><br>
		<input type="submit" value="로그인" /><br>
		<input type="button" value="취소" onclick="Location.href='${context}session/index'" /><br>
	</form>
</body>
</html>
