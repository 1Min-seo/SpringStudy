<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
<!-- 
		register라고 클라이언트가 요청하면 화면에 출력
		출력된 회원가입 페이지에 데이터입력 후 서버로 전달되어
		이클립스의 콘솔에 출력하기
 -->
 	<c:url value="/index" var="contextRoot"/>
 	<h3> ${msg }</h3>
 	<form action="register" method="post">
 		<input type="text" name="id" placeholder="아이디" /> <br>
 		<input type="password" name="pw" placeholder="비밀번호" /> <br>
 		<input type="text" name="name" placeholder="이름" /> <br>
 		<input type="submit" value="회원가입" />
 		<input type="button" value="취소" onclick="Location.href='${contextRoot }'" />
 	</form>
</body>
</html>
