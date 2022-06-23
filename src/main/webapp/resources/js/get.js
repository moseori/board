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
	let modalremoveBtn = $('#modalremoveBtn')
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
		modalInputReplyDate.closest('div').hide()
		modalModifyBtn.hide()
		modalremoveBtn.hide()
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
	
	$('.chat').on('click','li',function(){
		//alert('클릭'+$(this).data('rno'));
		//alert(rno);
		let rno=$(this).data('rno');
		
		replyService.get(rno, function(reply){
			console.log(reply)
		})
	})
})
