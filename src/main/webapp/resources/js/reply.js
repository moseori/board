let replyService=(function(){
	
	function add(reply, callback){
		console.log("reply~~");
	}

return {add:add};
})();

console.log(replyService);