function setThumbnail(event) {
	var reader = new FileReader();
	
	reader.onload = function(event) {
		console.log(event);		
		var img = document.getElementById("imageSample");
		img.setAttribute("src", event.target.result);
		
	};
	
	reader.readAsDataURL(event.target.files[0]);
}

var isIdCheck = true; 

function idDuplicateCheck(memberId) {
	
	var userId = document.getElementById("memberId").value;
	
	if(userId == "") {
		alert("아이디를 입력해주세요.");
		return;
	}
	
	if(userId == memberId) {
		alert("사용 가능한 아이디입니다.")
		return;
	} else {
		$.ajax({
			type : 'get', // 타입 (get, post, put 등등)    
			url : 'join/idCheck', // 요청할 서버url
			contentType : "application/json; charset=UTF-8",
			dataType : 'text',// 데이터 타입 (html, xml, json, text 등등)
			data : {  // 보낼 데이터 (Object , String, Array)
			"memberId" : userId,
			},
			success : function(result) { // 결과 성공 콜백함수
				if(result === "true") {
					isIdCheck = true;
					alert("사용 가능한 아이디 입니다.");
				} else {
					isIdCheck = false;
					alert("이미 사용중인 아이디 입니다.");
				}
				
				var subbutton = document.getElementById("submitBtn");
	
				if(subbutton != null) {
					if(!isIdCheck) {
						subbutton.disabled = true;	
					} else {
						subbutton.disabled = false;
					}
				}
			},
			error : function(request, status, error) { // 결과 에러 콜백함수
				
			}
		})
	}
	
}


function readApplyInfo(memberId) {
	window.location.href="./myInfo?mode=applyInfo&id=" + memberId; 
}

function readReportInfo(reportId) {
	window.location.href="./myInfo?mode=reportInfo&id=" + reportId;
}

function registBlack(memberId, reportId) {
	
	$.ajax({
		type:"POST",
		url:"./registBlack",
		data: {
			"memberId" : memberId,
			"reportId" : reportId
		},
		success : function(result) {
			if(result === "AlreadyRegistered") {
				alert("이미 블랙리스트에 등록이 되어있습니다.");
			} else if(result === "RegistrationCompleted") {
				alert("블랙리스트 등록이 완료되었습니다.");
			}
		},
		error : function(error) {
			
		}
	});
}

function sendWarning(memberId, type, title, reportId) {
	$.ajax({
		type:"POST",
		url:"./sendWarning",
		data: {
			"memberId" : memberId,
			"type" : type,
			"title" : title,
			"reportId" : reportId
		},
		success : function(result) {
			
		},
		error : function(error) {
			
		}
	});
}

function deleteMember(){
	console.log(document.getElementById("memberId"));
	console.log(document.getElementById("memberPw"));
	var memberId = document.getElementById("memberId").value;
	var memberPw = document.getElementById("memberPw").value;
	
	console.log("잘뜨고 잇냐?");
}

