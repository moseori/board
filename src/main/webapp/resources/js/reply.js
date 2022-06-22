let replyService = (function() {

	function add(reply, callback) {
		$.ajax({
			type: "post",
			url: contextPath + "/replies/new",
			data: JSON.stringify(reply),
			contentType: 'application/json;charset=utf-8',
			sucess: function(result, status, xhr) {
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

	return {
		add: add,
		getList: getList
	};
})();

console.log(replyService);