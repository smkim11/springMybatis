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
	<h1>BoardOne</h1>
	<a href="/boardList">목록</a>
	<a href="/updateBoard?boardNo=${board.boardNo }">수정</a>
	<a href="/deleteBoard?boardNo=${board.boardNo }">삭제</a>
	<table border="1">
		<tr>
			<th>No</th>
			<td>${board.boardNo }</td>
		</tr>
		<tr>
			<th>Title</th>
			<td>${board.boardTitle }</td>
		</tr>
		<tr>
			<th>Content</th>
			<td>${board.boardContent }</td>
		</tr>
		<tr>
			<th>User</th>
			<td>${board.boardUser }</td>
		</tr>
	</table>
	<script>
	
	</script>
</body>
</html>