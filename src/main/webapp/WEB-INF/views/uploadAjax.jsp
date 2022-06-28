<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<h2>피일 업로드 : AJAX</h2>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple="multiple">
	</div>
	<button id="uploadBtn">업로드</button>
</body>
<script>
	$(function() {
		let contextPath = '${pageContext.request.contextPath}';
		$('#uploadBtn').on('click', function() {
			let formData = new FormData();

			let inputFile = $('input[name="uploadFile"]');
			let files = inputFile[0].files
			console.log(files);

			for (let i = 0; i < files.length; i++) {
				formData.append("uploadFile", files[i])
			}

			$.ajax({
				url : contextPath + '/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData,
				type : 'post',
				success : function(result) {
					alert("Uploaded");
				}
			});
		})
	})
</script>
</html>