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
let regex=new RegExp("(.*?)\.(exe|sh|js|alz)$");
let maxSize=5242880;

function checkExtension(fileName, fileSize){
	if(fileSize >= maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
	if (regex.test(fileName)){
		alert("허용되지 않는 확장자");
		return false;
	}
	return true;
}

$(function(){
	let form = $('#registerForm');
		let submitBn = $('#registerForm button');
		form.on('click', function(e) {
			e.preventDefault();
			console.log("폼 기본동작금지");
		})

		//파일 업로드
		$('input[type="file"]').change(function() {
			let formData = new FormData();
			let inputFiles=$('input[name="uploadFile"]');
			let files=inputFiles[0].files;
			
			for(let f of files){
				if(!checkExtension(f.name, f.size)) return false;
				formData.append('uploadFile',f);
			}
			$.ajax({
				url :contextPath + '/uploadAjaxAction',
				type : 'post',
				processData : false,
				contentType : false,
				data : formData,
				dataType:'json',
				success : function(result){
					$(result).each(function(i,obj){
						console.log(obj.fileName);
						console.log(obj.uuid);
						console.log(obj.uploadPath);
					})
				}
			});
		})

	})//Document ready end
</script>
<%@ include file="../layout/footer.jsp"%>