<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../layout/header.jsp"%>
	<h2>수정페이지</h2> <br>
	<form action="modify" method="post">
		<input type="hidden" name="bno" value="${board.bno}"> 
		게시물 번호 :${board.bno} <br> 
		제목 : <input type="text" name="title" value="${board.title}"><br> 
		내용 : <textarea rows="" cols="">${board.contents}</textarea> <br> 
		작성자 : ${board.writer}<br>
		<button>수정</button>
	</form>
	<%@ include file="../layout/footer.jsp"%>
</body>
</html>