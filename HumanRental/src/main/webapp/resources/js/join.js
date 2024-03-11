var isIdCheck = false; 
var isNickCheck = false;

$(function() {
	var DupChkBtn = document.getElementsByClassName("DupChkBtn");
	
	for(var btn of DupChkBtn) {
		btn.addEventListener("click", function(event) {

			var targetLabel = event.target.parentElement.parentElement.children[0].innerText;
			
			var targetData = event.target.parentElement.parentElement.children[1].children[0].value;
			
			console.log(targetLabel);
			
			console.log(targetData);
			
			if(targetLabel == "아이디" && targetData == "") {
				alert("아이디를 입력해주세요.");
				return;
			}
			
			if(targetLabel == "닉네임" && targetData == "") {
				alert("닉네임을 입력해주세요.");
				return;
			}
			
			$.ajax({
				type : 'get', // 타입 (get, post, put 등등)    
				url : 'join/DupCheck', // 요청할 서버url
				contentType : "application/json; charset=UTF-8",
				dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)
				data : {  // 보낼 데이터 (Object , String, Array)
				"targetLabel" : targetLabel,
				"targetData" : targetData,
				},
				success : function(result) { // 결과 성공 콜백함수
					if(targetLabel === "아이디" && result === "true") {
						isIdCheck = true;
						alert("사용 가능한 아이디 입니다.");
					} else if(targetLabel === "아이디" && result === "false") {
						isNickCheck = false;
						alert("이미 사용중인 아이디 입니다.");
					}
					
					if(targetLabel === "닉네임" && result === "true") {
						isNickCheck = true;
						alert("사용 가능한 닉네임 입니다.");
					} else if(targetLabel === "닉네임" && result === "false") {
						isNickCheck = false;
						alert("이미 사용중인 닉네임 입니다.");
					}
					

				},
				error : function(request, status, error) { // 결과 에러 콜백함수
					console.log(request);
				}
			})
		})
	}
})



function formSubmit() {
	var ipValue = document.getElementById("memberId").value;
	var pwValue = document.getElementById("memberPw").value;
	
	if(ipValue == "" || pwValue == "") {
		alert("아이디 혹은 비밀번호를 확인해주세요.");
		return;
	}
	
	if(!isIdCheck) {
		alert("아이디 중복 확인을 해주십시오.");
		return;
	}
	
	if(!isNickCheck) {
		alert("닉네임 중복 확인을 해주십시오.");
		return;
	}
	
	document.getElementById("joinForm").submit();	
}




