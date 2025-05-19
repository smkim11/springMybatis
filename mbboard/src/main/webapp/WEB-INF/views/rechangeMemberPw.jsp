<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>rechangeMemberPw</h1>
	<form method="post" action="/rechangeMemberPw">
		<div>
			memberId <input type="text" name="memberId">
		</div>
		<div>
			메일로 받은 Pw <input type="password" name="memberPw">
		</div>
		<div>
			변경 비밀번호 <input type="password" name="newMemberPw">
		</div>
		<button type="submit">변경</button>
	</form>
</body>
</html>