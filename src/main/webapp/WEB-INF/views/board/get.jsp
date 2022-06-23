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
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#replyForm">
	댓글등록
	</button>


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
<!-- Modal -->
<div class="modal fade" id="replyForm" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">댓글달기</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="reply">내용입력</label> 
					<input class="form-control" name="reply" id="reply">
				</div>
				<div class="form-group">
					<label for="replyer">작성자</label> 
					<input class="form-control" name="replyer" id="replyer">
				</div>
				<div class="form-group">
					<label for="regDate">등록일</label> 
					<input class="form-control" name="regDate" id="regDate">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" id="modalModifyBtn">수정</button>
				<button type="button" class="btn btn-danger" id="modalremoveBtn">삭제</button>
				<button type="button" class="btn btn-primary" id="modalRegisterBtn">등록</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
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
		
		//모달창
		let modal=$('.modal');
		let modalInputReply = modal.find('input[name="reply"]');
		let modalInputReplyer = modal.find('input[name="replyer"]');
		let modalInputReplydate = modal.find('input[name="regDate"]');
		//모달이벤트 처리
		$('#modalRegisterBtn').on('click',function(){
			//let test=modalInputReply.val();
			let test=modalInputReplyer.val();
			alert(test);
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
