<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form action="register" method="post" id="registerForm">
		제목 : <input type="text" name="title"><br> 
		내용 : <textarea rows="10" cols="50" name="contents"></textarea> <br>
		작성자 : <input type="text" name="writer"> <br>
		<button>글쓰기</button>
	</form>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>파일 첨부</h4>
				</div>
				<div class="panel-body">
					<div class="form-group uploadDiv">
						<input type="file" name="uploadFile" multiple="multiple">
					</div>
					<div class="uploadResult">
						<ul></ul>
					</div>
				</div>
			</div>
		</div>

	</div>


</div>
<script>
$(function(){
	let form=$('#registerForm');
	form.on('click', function(e){
		e.preventDefault();
		console.log("폼 기본동작금지")
	})
})
</script>
<%@ include file="../layout/footer.jsp"%>