<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="" method="get" id="getForm">
		<input type="hidden" name="bno" value="${board.bno}"> 
		<input type="hidden" name="title" value="${board.title}"> 
		<input type="hidden" name="writer" value="${board.writer}"> 
		<input type="hidden" name="contents" value="${board.contents}"> 
		<div>
			<p>${board.title}</p>
			<p>작성자 : ${board.writer}</p>
			<p>
				등록일 :
				<fmt:parseDate var="regDate" value="${board.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" />
				<fmt:formatDate value="${regDate}" pattern="yyyy년MM월dd일 HH시mm분" />
				수정일 :
				<fmt:parseDate var="updateDate" value="${board.updateDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" />
				<fmt:formatDate value="${updateDate}" pattern="yyyy년MM월dd일 HH시mm분" />
			</p>
			<p>${board.contents}</p>
		</div>
		<button class="btn btn-warning modify">수정</button>
		<button class="btn btn-danger">삭제</button>
		<button class="btn btn-primary list">목록</button>
	</form>
</div>
<script>
	$(function() {
		let getForm = $("#getForm");
		$('#getForm .list').on('click', function() {
			getForm.empty();
			getForm.attr("action", "list");
			getForm.submit();
		})
		$('#getForm .modify').on('click', function() {
			getForm.attr("action", "modify");
			getForm.submit();
		})
	})
</script>
<%@ include file="../layout/footer.jsp"%>
