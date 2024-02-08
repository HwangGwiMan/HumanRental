function idDuplicateCheck() {
	
	var userName = document.getElementById("memberId").value;
	
	$.ajax({
		type : 'get', // 타입 (get, post, put 등등)    
		url : 'join/idCheck', // 요청할 서버url
		contentType : "application/json; charset=UTF-8",
		dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)
		data : {  // 보낼 데이터 (Object , String, Array)
		"memberId" : userName,
		},
		success : function(result) { // 결과 성공 콜백함수 
			 console.log(result);
			 alert(result);
		},
		error : function(request, status, error) { // 결과 에러 콜백함수
			console.log(request);
		}
	})

	
}