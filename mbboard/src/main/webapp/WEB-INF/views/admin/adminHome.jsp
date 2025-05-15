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
	<h1>${loginMember.memberId} 관리자</h1>
	<a href="/member/info">상세정보</a>
	<a href="/logout">로그아웃</a>
	<h2>멤버리스트</h2>
	<!-- 
		memberRole 수정
	 -->
	 <table border="1">
	 	<tr>
	 		<th>ID</th>
	 		<th>ROLE</th>
	 		<th>변경</th>
	 	</tr>
	 		<c:forEach var="m" items="${list}">
	 			<tr>
	 				<td>${m.memberId }</td>
	 				<td>${m.memberRole }</td>
	 				<td><a href="/updateRole?memberId=${m.memberId }&memberRole=${m.memberRole }">변경</a></td>
	 			</tr>
	 		</c:forEach>
	 </table>
	 
	 <script>

	 </script>
</body>
</html>