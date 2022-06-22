<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<script src="${contextPath }/resources/js/get.js"></script>
<div class="container">
	<div class="getData">
		<input type="hidden" name="page" id="page" value="${param.page}">
		<input type="hidden" name="type" id="type" value="${param.type}">
		<input type="hidden" name="keyword" id="keyword"
			value="${param.keyword}">
	</div>
	<form id="getForm">
		<input type="hidden" name="bno" value="${board.bno}">
		<div>
			<p>${board.title}</p>
			<p>작성자 : ${board.writer}</p>
			<p>
				등록일 :
				<fmt:parseDate var="regDate" value="${board.regDate}"
					pattern="yyyy-MM-dd'T'HH:mm:ss" />
				<fmt:formatDate value="${regDate}" pattern="yyyy년MM월dd일 HH시mm분" />
				수정일 :
				<fmt:parseDate var="updateDate" value="${board.updateDate}"
					pattern="yyyy-MM-dd'T'HH:mm:ss" />
				<fmt:formatDate value="${updateDate}" pattern="yyyy년MM월dd일 HH시mm분" />
			</p>
			<p>${board.contents}</p>
		</div>
		<button class="btn btn-warning modify">수정</button>
		<button class="btn btn-danger remove">삭제</button>
		<button class="btn btn-primary list">목록</button>
	</form>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel paner-default">
				<div class="panel-heading">
					<h4>댓글을 달아주세요</h4>
				</div>
				<div class="panel-body">
					<ul class="chat">
						<li data-rno='1'>
							<div>
								<div class='header'>
									<strong>홍길동</strong> 
									<small class='pull-right text-muted'>2022-02-22</small>
								</div>
								<p>댓글내용.....</p>
							</div>
						</li>

					</ul>
				</div>
			</div>
		</div>
	</div>
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

	$(function(){
		let bnoValue=$('input[name="bno"]').val();
		
		replyService.getList({bno:bnoValue},function(list){
			for(let reply of list){
				console.log(reply)
			}
		})
	})
	
	$(function(){
		//수정테스트
		function updateTest(){
		replyService.update({
			rno:13,
			bno:1,
			reply:"댓글 update"
		},function(result){
			alert(result)
		})
		}
		
		//delete 테스트
		function deleteTest(){
			replyService.remove(16, function(result){
				alert(result);
			},function(){
				alert('실패')
			})
			
		}
		//deleteTest();
	})

</script>
<%@ include file="../layout/footer.jsp"%>
