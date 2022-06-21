<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<div class="getData">
		<input type="hidden" name="page" id="page" value="${param.page}">
		<input type="hidden" name="type" id="type" value="${param.type}">
		<input type="hidden" name="keyword" id="keyword" value="${param.keyword}">
	</div>
	<form id="getForm">
		<input type="hidden" name="bno" value="${board.bno}"> 
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
		<button class="btn btn-danger remove">삭제</button>
		<button class="btn btn-primary list">목록</button>
	</form>
</div>
<script>
	$(function() {
		let getForm = $("#getForm");
		$('#getForm .list').on('click', function() { //목록
			getForm.empty();
			getForm.append($('#page'));
			getForm.append($('#type'));
			getForm.append($('#keyword'));
			getForm.attr("action", "list");
			getForm.submit();
		})
		$('#getForm .modify').on('click', function() { //수정페이지
			getForm.attr("action", "modify");
			getForm.submit();
		})
		$("#getForm .remove").on('click',function(){//삭제처리
			getForm.attr("method","post");
			getForm.attr("action","remove");
			getForm.submit();
		})
	})
	
	//댓글등록 테스트
	$(function() {
		let bnoValue = $('input[name="bno"]').val();
		let reply = {
			bno : bnoValue,
			reply : "ajax 댓글 등록 태스트",
			replyer : "테스터"
		};
		let callback = function(result) {
			alert("결과 : " + result);
		}

		replyService.add(reply, callback)
	})
</script>
<%@ include file="../layout/footer.jsp"%>
