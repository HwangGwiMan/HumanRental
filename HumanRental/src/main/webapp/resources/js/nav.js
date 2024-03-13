$(function() {
	var alarmBtn = document.getElementById("alarmBtn");
	
	alarmBtn.addEventListener("click", function(event) {
		var alarmBlock = event.target.parentElement.nextElementSibling;

		if(alarmBlock.style.display == "none") {
			alarmBlock.style.display = "block";
		} else {
			alarmBlock.style.display = "none";
		}
	})
})

var ws = new SockJS("http://localhost:8080/HumanRental/deleteAlarm");

function alarmDelete(id) {
	ws.send(id);
}

ws.onmessage = function(e) {
	updateAlarm(e.data);
}

function updateAlarm(message) {
	var alarmDiv = document.getElementById("alarmRow_" + message);
	var parent = alarmDiv.parentElement;
	
	parent.removeChild(alarmDiv);
	
	if(parent.children.length == 0) {
		parent.innerText = "알람이 없습니다.";
		
		var alarmLight = document.getElementById("alarmLight");
		alarmLight.style.display = "none";
	} 
}

function goMain() {
	window.location.href = "/HumanRental";
}