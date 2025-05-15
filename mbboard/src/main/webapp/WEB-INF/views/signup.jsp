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
	<h1>Signup</h1>
	<form method="post" action="/signup" id="signupForm">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberId" id="id"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="memberPw" id="pw"></td>
				<td><input type="password" id="pw2"></td>
			</tr>
			<tr>
				<th>ROLE</th>
				<td>
					<select name="memberRole" id="role">
						<option value="">:::선택:::</option>
						<option value="ADMIN">ADMIN</option>
						<option value="MEMBER">MEMBER</option>
					</select>
				</td>
			</tr>
		</table>
		<button type="button" id="btn">가입</button>
	</form>
	
	<script>
		$('#id').blur(function(){
			$.ajax({
				url:'/idUse/'+$('#id').val()
				,type:'get'
				,success: function(data){
					console.log(data);
					if(data==false){
						alert('이미 존재하는 아이디 입니다.');
						$('#id').val('');
					}
				}
				
			})
		});
		
		$('#pw2').blur(function(){
			if($('#pw').val() !== $('#pw2').val()){
				alert('비밀번호가 일치하지 않습니다.');
				$('#pw').val('');
				$('#pw2').val('');
			}
		});	
		
		$('#btn').click(function(){
			if($('#id').val() != '' && $('#pw').val() != '' 
			&& $('#pw2').val() != '' && $('#role').val() != ''){
				$('#signupForm').submit();
			}else{
				alert('입력하지 않은 값이 있습니다.');
			}
		
		});
		
	</script>
</body>
</html>