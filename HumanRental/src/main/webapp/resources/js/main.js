$(document).ready(function() {

});

function goMentorProfile(element) {
	var nickname = element.getAttribute("nickname");
	var url = "/HumanRental/mentorprofilepage?nickname=" + nickname;
	window.location.href = url;
}

function goBoard(element) {
	var board = element.getAttribute("board");
	var url;
	if(board.includes('buy')){
		url = "/HumanRental/buying/detail?buyingId=" + board;
	}
	else{
		url = "/HumanRental/selling/detail?sellingId=" + board;
	}
	window.location.href = url;
}


function goSelling(element) {
	var category = element.getAttribute("category");
	var url = "/HumanRental/SellingList?category=" + category;
	window.location.href = url;
}