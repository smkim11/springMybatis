<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	<form method="post" action="/findMemberPw">
		ID : <input type="text" name="memberId"><br>
		Email : <input type="text" name="email"><br>
		<button type="submit">찾기</button>
	</form>
</body>
</html>