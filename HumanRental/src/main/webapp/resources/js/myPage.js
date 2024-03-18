//var isIdCheck = false; 
//var isNickCheck = false;

$(function() {
	var profileBtn = document.getElementById("profileBtn");
	var registBtn = document.getElementById("registBtn");
	var resvBtn = document.getElementById("resvBtn");
	
	if(profileBtn !== null) {
		profileBtn.addEventListener("click", function(event) {
			var menu = profileBtn.nextElementSibling;
			if(menu.style.display === "none") {
				menu.style.display = "block";	
			} else {
				menu.style.display = "none";
			}
		})
	}
	
	if(registBtn !== null) {
		registBtn.addEventListener("click", function(event) {
			var menu = registBtn.nextElementSibling;
			if(menu.style.display === "none") {
				menu.style.display = "block";	
			} else {
				menu.style.display = "none";
			}
		})
	}
	
	if(resvBtn !== null) {
		resvBtn.addEventListener("click", function(event) {
			var menu = resvBtn.nextElementSibling;
			if(menu.style.display === "none") {
				menu.style.display = "block";	
			} else {
				menu.style.display = "none";
			}
		})
	}
	
	// 어드민 데이터 정렬
	try {	
		var thead = document.getElementById("thead").children;
		var sort;
		var sortTarget;
		
		for(var head of thead) {
			
			if(head.innerText === "순번") {
				continue;
			} else {
				for(var icon of head.children) {
					if(icon.classList.contains("fa-sort")) {
						icon.addEventListener("click", function(e) {
							sort = 1;
							for(var otherCol of e.target.parentNode.parentNode.childNodes) {
								if(otherCol.nodeName === '#text' || otherCol == e.target.parentNode || otherCol.innerText === "순번") {
									continue;
								} else {
									for(var icon of otherCol.children) {
										if(icon.classList.contains("fa-sort")) {
											icon.style.display = "inline";	
										} else {
											icon.style.display = "none";
										}
									};
								}
							}
							e.target.style.display = "none";
							e.target.nextSibling.style.display = "inline";
							
							sortTarget =  e.target.parentElement.childNodes[0].data;
							sendSortRequest(sort, sortTarget);
						})
					} else if(icon.classList.contains("fa-sort-up")) {
						icon.addEventListener("click", function(e) {
							sort = 2;						
							e.target.style.display = "none";
							e.target.nextSibling.style.display = "inline";
							
							sortTarget =  e.target.parentElement.childNodes[0].data;
							sendSortRequest(sort, sortTarget);
						});
					} else {
						icon.addEventListener("click", function(e) {
							sort = 0;						
							e.target.style.display = "none";
							e.target.previousSibling.previousSibling.style.display = "inline";
							
							sortTarget =  e.target.parentElement.childNodes[0].data;
							sendSortRequest(sort, sortTarget);
						})
					}
				}
			}
		}
	} catch (err) {

	}

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
						isIdCheck = false;
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
	//var ipValue = document.getElementById("memberId").value;
	
	/*if(ipValue == "") {
		alert("아이디를 확인해주세요.");
		return;
	}
	
	if(!isIdCheck) {
		alert("아이디 중복 확인을 해주십시오.");
		return;
	}
	
	if(!isNickCheck) {
		alert("닉네임 중복 확인을 해주십시오.");
		return;
	}*/
	
	document.getElementById("editForm").submit();	
}


function setThumbnail(event) {
	var reader = new FileReader();
	
	reader.onload = function(event) {
		console.log(event);		
		var img = document.getElementById("imageSample");
		img.setAttribute("src", event.target.result);
		
	};
	
	reader.readAsDataURL(event.target.files[0]);
}



function readApplyInfo(memberId, registId) {
	window.location.href="./myInfo?mode=applyInfo&id=" + registId; 
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
			alert("경고문구를 전송했습니다.");
		},
		error : function(error) {
			
		}
	});
}

function deletemember22() {
    var memberId = document.getElementById("memberId").value;
    var memberPw = document.getElementById("memberPw").value;

    console.log(memberId);
    console.log(memberPw);

    $.ajax({
        type: 'POST',
        url: '/HumanRental/deleteMember',
        data: { 
            "memberId": memberId,
            "memberPw": memberPw,
        },
        success: function(response) {
            if(response === "success") {
                alert('회원 탈퇴가 성공적으로 완료되었습니다.');
                location.reload();
            } else {
                alert('회원 탈퇴에 실패하였습니다.');
            }
        },
        error: function(request, status, error) {
            alert('회원 탈퇴 처리 중 오류가 발생했습니다: ' + error);
        }
    });
}

function userCheck() {
	var memberId = document.getElementsByName("memberId")[0].value;
	var memberPw = document.getElementsByName("memberPw")[0].value;
	
	console.log(memberId);
	console.log(memberPw);
	
	$.ajax({
        type: 'post',
        url: './myInfo',
        data: {
			"memberId" : memberId,
			"memberPw" : memberPw
		},
        success: function(result) {
            if (result === "true") {
                window.location.href = "./myInfo?mode=myPageEdit";
            } else {
				alert("아이디 비밀번호를 다시 확인해주세요.");	
			}
        },
        error: function(request, status, error) {
            console.log(request);
        }
    });
}

// 어드민 데이터 정렬
function sendSortRequest(sort, sortTarget) {

	var searchParams = new URLSearchParams(window.location.search);

/*	for(const param of searchParams) {
	  console.log(param);
	}*/
	
	var data = {};
	
	if(searchParams.get("mode") !== null ) {
		data.mode = searchParams.get("mode");
	};
	
	if(searchParams.get("t") !== null ) {
		data.t = searchParams.get("t");
	};
	
	data.sort = sort;
	data.sortTarget = sortTarget;
	
	console.log(sortTarget);
	
	$.ajax({
        type: 'GET',
        url: './myInfo',
		//contentType : "application/json; charset=UTF-8",
		//dataType : "text/html",
        data: data,
        success: function(result) {		
			oldT = document.getElementById("tbody");
			newT = $(result)[43].getElementsByTagName("tbody")[0];
						
			oldT.innerHTML = newT.innerHTML;
        },
        error: function(request, status, error) {
            console.log(request);
        }
    });
}

function goBack() {
    // 브라우저의 이전 페이지로 이동
    history.back();
}

function reviewCheck(element) {
    var reservationId = element.getAttribute('reservationId');
    $.ajax({
        type: 'get',
        url: './ReviewCheck',
        data: {"reservationId" : reservationId},
        success: function(result) {
			console.log(result);
            if (result === "true") {
				window.location.href = "./ReviewWrite?reservationId=" + reservationId;
            } 
            else if(result === "false") {
                alert("이미 후기를 작성하셨습니다.");
            }
            
        },
        error: function(request, status, error) {
            console.log(request);
        }
    });
}

function reviewCheck2(element) {
    var reservationId = element.getAttribute('reservationId');
    $.ajax({
        type: 'get',
        url: './ReviewCheck2',
        data: {"reservationId" : reservationId},
        success: function(result) {
			console.log(result);
            if (result === "false") {
                alert("후기를 작성해주세요.");
            } 
            else {
				window.location.replace("./ReviewRead?reservationId=" + reservationId);
            }
            
        },
        error: function(request, status, error) {
            console.log(request);
        }
    });
}
//멘토프로필 자격증 파일 업로드용 함수 3개 시리즈
function setThumbnail11(event) {
	var reader = new FileReader();
	
	reader.onload = function(event) {
		console.log(event);		
		var img = document.getElementById("imageSample11");
		img.setAttribute("src", event.target.result);
		
	};
	
	reader.readAsDataURL(event.target.files[0]);
}

function setThumbnail22(event) {
	var reader = new FileReader();
	
	reader.onload = function(event) {
		console.log(event);		
		var img = document.getElementById("imageSample22");
		img.setAttribute("src", event.target.result);
		
	};
	
	reader.readAsDataURL(event.target.files[0]);
}

function setThumbnail33(event) {
	var reader = new FileReader();
	
	reader.onload = function(event) {
		console.log(event);		
		var img = document.getElementById("imageSample33");
		img.setAttribute("src", event.target.result);
		
	};
	
	reader.readAsDataURL(event.target.files[0]);
}

//이미지 누르면 이미지 팝업창 보여주는 함수
function openImagePopup(src) {
    // 팝업창에서 이미지를 열기
    window.open(src, 'ImagePopup', 'width=600,height=600');
}


//멘토 멘티 체크박스확인하는 자바스크립트
function checkAndSubmit() {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    var checkedOne = Array.from(checkboxes).some(x => x.checked);

    if (!checkedOne) {
        alert('적어도 하나의 분야를 선택해야 합니다.');
        event.preventDefault(); // 폼 제출을 막음

    } else {
        // 폼 제출
       document.getElementById('checkedcheckbox').submit();
     	 }
    }
