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

window.onload = function() {
	console.log(document.getElementById("pageMove"));
}