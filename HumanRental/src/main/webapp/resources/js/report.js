function reportSubmit() {
	
	var target = document.getElementsByName("target")[0];
	var memberId = document.getElementsByName("memberId")[0];
	var type = document.getElementsByName("type")[0];
	var boardId = document.getElementsByName("boardId")[0];
	
	var data = {  
		"target" : target.value,
		"memberId" : memberId.value,
		"type" : type.value
		}
	
	$.ajax({
		type : 'post', // 타입 (get, post, put 등등)    
		url : './report', // 요청할 서버url
		/*contentType : "application/json; charset=UTF-8",*/
		/*dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)*/
		data : "target=" + target.value + "&memberId=" + memberId.value + "&type=" + type.value + "&boardId=" + boardId.value,
		success : function(result) { // 결과 성공 콜백함수
			alert("신고가 완료되었습니다.");
			window.close();
		},
		error : function(request, status, error) { // 결과 에러 콜백함수
			
		}
	})

}