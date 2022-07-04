$(function() {
	let bnoValue = $('input[name="bno"]').val();
	let replyUL = $('.chat');

	//모달창
	let bno = $('input[name="bno"]').val();
	let modal = $('.modal');
	let modalInputReply = modal.find('input[name="reply"]');
	let modalInputReplyer = modal.find('input[name="replyer"]');
	let modalInputReplyDate = modal.find('input[name="regDate"]');

	let modalModifyBtn = $('#modalModifyBtn')
	let modalRemoveBtn = $('#modalRemoveBtn')
	let modalRegisterBtn = $('#modalRegisterBtn')
	let modalCloseBtn = $('#modalCloseBtn')
	
	function showList(page) {
		replyService.getList({ bno: bnoValue, page: page }, function(list) {
			let str = "";
			for(let reply of list) {
				str += `
					<li data-rno="${reply.rno}">
						<div>
							<div class="header">
								<strong class="primary-font">${reply.replyer}</strong>
								<small class="pull-right text-muted">${displayTime(reply.regDate)}</small>
							</div>
							<p>${reply.reply}</p>
						</div>
   					</li>`
			}
			replyUL.html(str);
		});
	}
	showList(1);
		
	function displayTime(timeValue){
		//console.log(timeValue);
		let timeArr=JSON.stringify(timeValue).substr(1).split(",");
		//console.log(timeArr);
		return `${timeArr[0]}년 ${timeArr[1]}월 ${timeArr[2]}일`;
	}
	
	

	//댓글동록 모달창
	$('#addReplyBtn').click(function() {
		modal.find('input').val('')
		modalInputReplyDate.closest('div').hide()
		modalModifyBtn.hide()
		modalRemoveBtn.hide()
		modalRegisterBtn.show()
	})


	//모달이벤트 처리
	modalRegisterBtn.on('click', function() {
		let reply = {
			reply: modalInputReply.val(),
			replyer: modalInputReplyer.val(),
			bno: bno
		}
		replyService.add(reply, function(result) {
			alert(result)
			modal.modal('hide');
			showList(1);
		})
	})
	
	//수정,삭제 모달창
	$('.chat').on('click','li',function(){
		//alert('클릭'+$(this).data('rno'));
		//alert(rno);
		let rno=$(this).data('rno');
		
		replyService.get(rno, function(reply){
			console.log(reply);
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(displayTime(reply.updateDate)).attr("readonly","readonly");
			modal.data("rno",reply.rno);
			
			modalInputReplyDate.closest('div').show();
			modalModifyBtn.show();
			modalRemoveBtn.show();
			modalRegisterBtn.hide();
			modal.modal("show");
		})
	})
	
	//댓글 수정 이벤트
	modalModifyBtn.on("click", function() {
		let reply = {
			rno: modal.data('rno'),
			reply: modalInputReply.val(),
		};
		replyService.update(reply, function(result) {
			alert(result);
			modal.modal('hide');
			showList(1);
		});
	})
	
	//댓글 삭제 이벤트
	modalRemoveBtn.on('click', function() {
		let rno = modal.data('rno');
		replyService.remove(rno, function(result) {
			alert(result);
			modal.modal('hide');
			showList(1);
		})
	})
	
	//첨부파일 리스트 불러오기
	$.getJSON(contextPath + "/board/getAttachList", { bno: bnoValue }, function(attachList) {
		//console.log(attachList);
		let str = "";
		$(attachList).each(function(i, obj) {
			if (!obj.fileType) {//이미지 아닌경우
				let fileCellPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);

				str += "<li class='list-group-item' data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>"
				str += "<img src='"+contextPath+"/resources/img/attach.png' width=25px>";
				str += "<a href='"+contextPath+"/download?fileName=" + fileCellPath + "'>" + obj.fileName + "</a>";
				str += "</li>";
			} else {
				let fileCellPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
				let originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g), "/");

				str += "<li class='list-group-item' data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>"
				str += "<img src='"+contextPath+"/display?fileName=" + fileCellPath + "'>";
				str += "<a href='"+contextPath+"/download?fileName=" + fileCellPath + "'>" + obj.fileName + "</a>";
				str += "</li>"
			}
		}) //each end
		$('.uploadResult ul').append(str);
	})
	
})