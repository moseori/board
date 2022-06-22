$(function() {
	let bnoValue = $('input[name="bno"]').val();
	let replyUL = $('.chat');

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
})