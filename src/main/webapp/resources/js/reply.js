console.log(csrfHeaderName)
console.log(csrfTokenName)

let replyService = (function() {

	function add(reply, callback,error) {
		$.ajax({
			type: "post",
			url: contextPath + "/replies/new",
			data: JSON.stringify(reply),
			contentType: 'application/json;charset=utf-8',
			brforeSend :function(xhr){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenName);
			},
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	//댓글목록
	function getList(param, callback, error) {
		let bno = param.bno;
		let page = param.page || 1;

		let url = contextPath + '/replies/page/' + bno + '/' + page;
		let success = function(data) {
			if (callback) { callback(data) }
		}

		$.getJSON(url, success).fail(function(xhr, status, err) {
			if (error) { error(); }
		});
	}

	//댓글삭제
	function remove(rno, callback, error) {
		$.ajax({
			type: "delete",
			url: contextPath + "/replies/" + rno,
			brforeSend :function(xhr){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenName);
			},
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}// deldte end

	function update(reply, callback, error) {
		$.ajax({
			type: "put",
			url: contextPath + "/replies/" + reply.rno,
			data: JSON.stringify(reply),
			contentType: 'application/json;charset=utf-8',
			brforeSend :function(xhr){
				xhr.setRequestHeader(csrfHeaderName, csrfTokenName);
			},
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}// update end
	
	function get(rno, callback, error){
		$.get(contextPath+"/replies/"+rno, function(result){
			if(callback) callback(result)
		}).fail(function(xhr, status, err){
			if(error) error(err)
		})
	}

	return {
		add: add,
		getList: getList,
		remove: remove,
		update: update,
		get:get //*주의*
	};
})();

console.log(replyService);