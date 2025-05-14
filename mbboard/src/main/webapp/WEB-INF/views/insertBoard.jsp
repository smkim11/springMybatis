<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>InsertBoard</h1>
	<form method="post" action="/insertBoard" id="insertForm">
		<table border="1">
			<tr>
				<th>Title</th>
				<td><input type="text" name="boardTitle" id="title"></td>
			</tr>
			<tr>
				<th>Content</th>
				<td><textarea name="boardContent" id="content"></textarea></td>
			</tr>
			<tr>
				<th>User</th>
				<td><input type="text" name="boardUser" id="user"></td>
			</tr>
		</table>
		<button type="button" id="btn">입력</button>
	</form>
	
	<script>
	
		$('#btn').click(function(){
			if($('#title').val() != '' && $('#content').val() != '' && $('#user').val() != ''){
				$('#insertForm').submit();
			}else{
				alert('입력하지 않은 값이 있습니다.');
			}
		});
	
		
	</script>
</body>
</html>