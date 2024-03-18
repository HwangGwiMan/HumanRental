function mentorCheck(element) {
	var buyingId = element.getAttribute('data-buying-id');
	$.ajax({
		type: 'get',
		url: './mentorprofileCheck',
		success: function(result) {
			if (result === "true") {
				window.location.href = "./buying/detail?buyingId=" + buyingId;
			} else if (result === "notLogin") {
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

function menteeCheck2() {
	$.ajax({
		type: 'get',
		url: './menteeprofileCheck',
		success: function(result) {
			if (result === "true") {
				window.location.href = "./buying";
			} else if (result === "notLogin") {
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

function showCalendar() {
	var calendarForm = document.getElementById("calendarForm");
	if (calendarForm.style.display === "none") {
		calendarForm.style.display = "block";
	} else {
		calendarForm.style.display = "none";
	}
}

function deleteBuying(element){
    var buyingId = element.getAttribute("boradId")
	window.location.href = "/HumanRental/buying/delete?buyingId="+buyingId;
}


function updateBuying(element){
    var buyingId = element.getAttribute("boradId")
	window.location.href = "/HumanRental/buying/update?buyingId="+buyingId;
}







