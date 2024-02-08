function loginCheck() {
	
	var memberId = document.getElementById("memberId").value;
	var memberPw = document.getElementById("memberPw").value;
	
	$.ajax({
		type : 'post', // 타입 (get, post, put 등등)    
		url : './login', // 요청할 서버url
		contentType : "application/json; charset=UTF-8",
		dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)
		data : JSON.stringify({  // 보낼 데이터 (Object , String, Array)
		"memberId" : memberId,
		"memberPw" : memberPw
		}),
		success : function(result) { // 결과 성공 콜백함수
			if(result === "false") {
				alert("아이디와 비밀번호를 확인해주세요.");	
			} else {
				window.location.href = "./main"
			}
		},
		error : function(request, status, error) { // 결과 에러 콜백함수
			console.log(request);
		}
	})
}