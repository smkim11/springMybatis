<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인이 안되어 있을 때 -->
	<c:if test="${loginMember == null}">
		<h1>Login</h1>
		<form method="post" action="/login">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberId" value="${cookie.saveId.value}"></td><!-- cookie.getSaveId() -->
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
	</c:if>
	
	<!-- 로그인이 되어 있다면 -->
	<c:if test="${loginMember != null}">
		<div>
			${loginMember.memberId}님 <a href="/member/memberHome">memberHome</a>으로 이동
		</div>
		<div><a href="/">조회수</a></div>
		<div><a href="/logout">로그아웃</a></div>
	</c:if>
</body>
</html>