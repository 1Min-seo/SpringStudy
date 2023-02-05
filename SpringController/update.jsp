<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<c:url value="/index" var="contextRoot" />
	<h3> ${msg }</h3>
	<form action="update" method="post">
												<%-- session.getAttribute("id"); --%>
		<input type="text" readonly="readonly" value="${sessionScope.id }" /><br>
		<input type="password" name="pw" placeholder="비밀번호" /><br>
		<input type="text" name="name" value="${sessionScope.name }" /><br>
		<input type="submit" value="회원 수정" />
		<input type="button" value="취소" onclick="Location.href='${contextRoot}'" /><br>
	</form>
</body>
</html>
