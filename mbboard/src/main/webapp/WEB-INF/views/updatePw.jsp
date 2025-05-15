<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>UpdatePw</h1>
	<form method="post" action="/updatePw" id="updateForm">
		<table border="1">
		<input type="hidden" name="memberId" value="${loginMember.memberId}">
			<tr>
				<th>PrevPw</th>
				<td><input type="password" name="prevPw" id="prevPw"></td>
			</tr>
			<tr>
				<th>NewPw</th>
				<td><input type="password" name="memberPw" id="memberPw"></td>
			</tr>
			<tr>
				<th>NewPw2</th>
				<td><input type="password" name="memberPw2" id="memberPw2"></td>
			</tr>
		</table>
		<button type="button" id="btn">수정</button>
	</form>
	
	<script>
		
		$('#btn').click(function(){
				if($('#memberPw').val() !== $('#memberPw2').val()){
					alert('변경 비밀번호가 일치하지 않습니다.');
					$('#memberPw').val('');
					$('#memberPw2').val('');
				}else{
					$('#updateForm').submit();
				}
		});
	</script>
</body>
</html>