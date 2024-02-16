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