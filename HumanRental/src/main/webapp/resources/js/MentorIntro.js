function mentorCheck() {
	
	$.ajax({
		type : 'get', // 타입 (get, post, put 등등)    
		url : './mentorCheck', // 요청할 서버url
		dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)
		contentType : "application/json; charset=UTF-8",
		dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)
		data : {  // 보낼 데이터 (Object , String, Array)

		},
		success : function(result) { // 결과 성공 콜백함수
			if(result == 'true') {
				window.location.href = "./mentorApply";
			} else if(result == "notLogin") {
				alert("로그인이 필요합니다.");
				window.location.href="./login";
			} else {
				alert("이미 멘토 등록이 되어 있습니다.");
				window.location.href = "./main";
			}
		},
		error : function(request, status, error) { // 결과 에러 콜백함수
			console.log(request);
		}
	})
}