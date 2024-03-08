function saveCheck(event, element) {
    var savelistid = $(element).data('id'); // data-id에서 buyingId를 가져옵니다.
    console.log(savelistid);

    $.ajax({
        type: 'GET',
        url: '/HumanRental/save/saveinsert', // 컨트롤러 매핑 URL
        data: { "savelistId": savelistid },
        success: function(response) {
            // 성공 처리 로직이 필요합니다.
            // 예시: 찜하기 상태를 토글하거나 메시지를 표시합니다.
            if(response == 'redirect:/save/saveread') {
                alert('찜하기 성공!');
                //window.location.href = "./save/saveread";
            } else {
                alert('이미 찜한 상태입니다.');
            }
            
            
        },
        error: function(request, status, error) {
            // 에러 발생 시 사용자에게 알림을 줍니다.
            alert('찜하기 실패: ' + error);
        }
    });
}

function callreservationform(id, title) {
    var calendarForm = document.getElementById('calendarForm');
    calendarForm.style.display = 'block';

    document.getElementById('reservationTitle').innerText = title;
    document.getElementById('reservationId').value = id;
}
	
function setFormAction() {
    var form = document.getElementById('reservationForm');
    var saveListId = document.getElementsByName('id')[0].value;
    console.log(saveListId);
    if (saveListId.includes('buying')) {
        form.action = "/HumanRental/save/buying?buyingId="+saveListId;
        console.log("Form action set to: " + form.action);
    } else if (saveListId.includes('selling')) {
        form.action = "/HumanRental/save/selling?sellingId="+saveListId;
        console.log("Form action set to: " + form.action);
    }
    
    
    
}
