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
	<h1>UpdateBoard</h1>
	<form method="post" action="/updateBoard" id="updateForm">
	<table border="1">
		<tr>
			<th>No</th>
			<td><input type="text" name="boardNo" id="no" value="${board.boardNo }" readonly></td>
		</tr>
		<tr>
			<th>Title</th>
			<td><input type="text" name="boardTitle" id="title" value="${board.boardTitle }"></td>
		</tr>
		<tr>
			<th>Content</th>
			<td><textarea name="boardContent" id="content">${board.boardContent }</textarea></td>
		</tr>
		<tr>
			<th>User</th>
			<td><input type="text" name="boardUser" id="user" value="${board.boardUser }"></td>
		</tr>
	</table>
	<button type="button" id="btn">수정</button>
	</form>
	
	<script>
		$('#btn').click(function(){
			if($('#no').val() != '' && $('#title').val() != '' 
					&& $('#content').val() != '' && $('#user').val() != ''){
				$('#updateForm').submit();
			}else{
				alert('입력하지 않은 값이 있습니다.');
			}
		});
		
	</script>
</body>
</html>