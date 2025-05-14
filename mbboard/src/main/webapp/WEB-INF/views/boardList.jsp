<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BoardList</h1>
	<a href="/insertBoard">추가</a>
	<table border="1">
		<tr>
			<th>No</th>
			<th>Title</th>
		</tr>
			<c:forEach var="b" items="${list}">
				<tr>
					<td>${b.boardNo}</td>
					<td><a href="/boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
				</tr>
			</c:forEach>
	</table>
	<a href="/boardList?currentPage=1&searchWord=${p2.searchWord}" id="first">처음</a>
	<a href="/boardList?currentPage=${p2.currentPage-1}&searchWord=${p2.searchWord}" id="prev">이전</a>
		${p2.currentPage}/${lastPage}
	<a href="/boardList?currentPage=${p2.currentPage+1}&searchWord=${p2.searchWord}" id="next">다음</a>
	<a href="/boardList?currentPage=${lastPage }&searchWord=${p2.searchWord}" id="last">마지막</a>
	
	<form action="/boardList" id="search">
		<input type="text" name="searchWord" id="searchWord">
		<button type="button" id="btn">검색</button>
	</form>
	
	
	<script>
		let currentPage = ${p2.currentPage};
		let lastPage = ${lastPage};
		
		if(currentPage<=1){
			$('#prev').hide();
			$('#first').hide();
		}
		
		if(currentPage==lastPage){
			$('#next').hide();
			$('#last').hide();
		}
		
		$('#btn').click(function(){
			$('#search').submit();
		})
	</script>
</body>
</html>