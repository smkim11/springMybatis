<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form method="post" action="/cookieLogin">
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" name="memberId" value="${cookie.loginMemberId.value}"></td><!-- cookie.getSaveId() -->
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" name="memberPw"></td>
		</tr>
	</table>
	<button type="submit">로그인</button>
	<input type="checkbox" value="yes" name="saveIdCk">아이디 저장
	<div><a href="/signup">회원가입</a></div>
	</form>
</body>
</html>