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
})

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

$(function() {
	var profileBtn = document.getElementById("profileBtn");
	var registBtn = document.getElementById("registBtn");
	var resvBtn = document.getElementById("resvBtn");
	
	profileBtn.addEventListener("click", function(event) {
		var menu = profileBtn.nextElementSibling;
		if(menu.style.display === "none") {
			menu.style.display = "block";	
		} else {
			menu.style.display = "none";
		}
	})
	
	registBtn.addEventListener("click", function(event) {
		var menu = registBtn.nextElementSibling;
		if(menu.style.display === "none") {
			menu.style.display = "block";	
		} else {
			menu.style.display = "none";
		}
	})
	
	resvBtn.addEventListener("click", function(event) {
		var menu = resvBtn.nextElementSibling;
		if(menu.style.display === "none") {
			menu.style.display = "block";	
		} else {
			menu.style.display = "none";
		}
	})
})

function mentorCheck(element) {
    var buyingId = element.getAttribute('data-buying-id');
    $.ajax({
        type: 'get',
        url: './mentorprofileCheck',
        success: function(result) {
            if (result === "true") {
                window.location.href = "./buying/detail?buyingId=" + buyingId;
            } else if (result === "notLogin"){
            	alert("로그인이 필요합니다.");
            }
            else {
                alert("멘토 프로필을 등록한 회원만 조회 가능합니다.");
            }
            
        },
        error: function(request, status, error) {
            console.log(request);
        }
    });
}

function mentorCheck2(element) {
    $.ajax({
        type: 'get',
        url: './mentorprofileCheck',
        success: function(result) {
            if (result === "true") {
                window.location.href = "./selling";
            } else if (result === "notLogin"){
            	alert("로그인이 필요합니다.");
            } else {
                alert("멘토 프로필을 등록한 회원만 등록 가능합니다.");
            }
        },
        error: function(request, status, error) {
            console.log(request);
        }
    });
}

function menteeCheck(element) {
    var SellingId = element.getAttribute('data-selling-id');
    $.ajax({
        type: 'get',
        url: './menteeprofileCheck',
        success: function(result) {
            if (result === "true") {
                window.location.href = "./selling/detail?sellingId=" + SellingId;
            } else if (result === "notLogin"){
            	alert("로그인이 필요합니다.");
            } else {
                alert("멘티 프로필을 등록한 회원만 조회 가능합니다.");
            }
        },
        error: function(request, status, error) {
            console.log(request);
        }
    });
}


function menteeCheck2() {
    $.ajax({
        type: 'get',
        url: './menteeprofileCheck',
        success: function(result) {
            if (result === "true") {
                window.location.href = "./buying";
            } else if (result === "notLogin"){
            	alert("로그인이 필요합니다.");
            } else {
                alert("멘티 프로필을 등록한 회원만 등록 가능합니다.");
            }
        },
        error: function(request, status, error) {
            console.log(request);
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
	
	$.ajax({
        type: 'GET',
        url: './myInfo',
		//contentType : "application/json; charset=UTF-8",
		//dataType : "text/html",
        data: data,
        success: function(result) {			
			oldT = document.getElementById("tbody");
			newT = $(result)[41].getElementsByTagName("tbody")[1];

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
                alert("이미 후기를 작성하셨습니다.");
            } 
            else if(result === "false") {
				window.location.href = "./ReviewWrite?reservationId=" + reservationId;
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