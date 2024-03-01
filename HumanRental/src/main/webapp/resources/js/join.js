var isIdCheck = false; 

function idDuplicateCheck() {
	
	var userName = document.getElementById("memberId").value;
	
	if(userName == "") {
		alert("아이디를 입력해주세요.");
		return;
	}
	
	$.ajax({
		type : 'get', // 타입 (get, post, put 등등)    
		url : 'join/idCheck', // 요청할 서버url
		contentType : "application/json; charset=UTF-8",
		dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)
		data : {  // 보낼 데이터 (Object , String, Array)
		"memberId" : userName,
		},
		success : function(result) { // 결과 성공 콜백함수
			if(result === "true") {
				isIdCheck = true;
				alert("사용 가능한 아이디 입니다.");
			} else {
				isIdCheck = false;
				alert("이미 사용중인 아이디 입니다.");
			}
		},
		error : function(request, status, error) { // 결과 에러 콜백함수
			console.log(request);
		}
	})
}

function formSubmit() {
	var ipValue = document.getElementById("memberId").value;
	var pwValue = document.getElementById("memberPw").value;
	
	if(ipValue == "" || pwValue == "") {
		alert("아이디 혹은 비밀번호를 확인해주세요.");
		return;
	}
	

	if(isIdCheck) {
		document.getElementById("joinForm").submit();
	} else {
		alert("아이디 중복 확인을 해주십시오.");
		return;
	}
}




