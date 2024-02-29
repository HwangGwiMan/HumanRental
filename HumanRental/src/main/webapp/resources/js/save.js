/*function saveCheck(event, element) {
    var savelistid = $(element).data('id'); // data-id에서 buyingId를 가져옵니다.
    console.log(savelistid);

    $.ajax({
        type: 'GET',
        url: '/HumanRental/save/saveinsert',
        data: { "savelistId": savelistid },
        success: function(response) {
            // 성공 처리 로직이 필요합니다.
            // 예시: 찜하기 상태를 토글하거나 메시지를 표시합니다.
            alert('찜하기 상태: ' + (response.includes('redirect') ? '이미 찜한 상태입니다.' : '찜하기 성공!'));
        },
        error: function(request, status, error) {
            // 에러 발생 시 사용자에게 알림을 줍니다.
            alert('찜하기 실패: ' + error);
        }
    });
}*/
function saveCheck(event, element) {
    var savelistid = $(element).data('id'); // data-id에서 buyingId를 가져옵니다.
    console.log(savelistid);

    $.ajax({
        type: 'GET',
        url: '/HumanRental/save/saveinsert',
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