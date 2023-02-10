<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
 	<c:url value="/index" var="contextRoot"/>
 	<h3> ${msg }</h3>
 	<form action="register" method="post">
 		<input type="text" name="id" placeholder="아이디" /> <br>
 		<input type="password" name="pw" placeholder="비밀번호" /> <br>
 		<input type="text" name="name" placeholder="이름" /> <br>
 		<input type="text" name="email" placeholder="이메일" /> <br>
 		<input type="submit" value="회원가입" />
 		<input type="button" value="취소" onclick="Location.href='${contextRoot }'" />
 	</form>
</body>
</html>
