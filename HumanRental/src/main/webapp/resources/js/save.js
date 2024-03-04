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

function callreservationform(element) {
  let id = encodeURIComponent(element.getAttribute('data-id'));
  
  let newWindow = window.open("", "newWindow", "width=500,height=400");
  newWindow.document.open();
  newWindow.document.write("<!DOCTYPE html>");
  newWindow.document.write("<html><head><meta charset='utf-8'><style>body {display: flex;justify-content: center;align-items: center;height: 100vh;}</style></head><body>");
  newWindow.document.write("<div><h1>예약 화면입니다!</h1>");
  newWindow.document.write("<form id='reservationForm' method='post' action='/HumanRental/reservation/buying'>"); 
  newWindow.document.write("<input type='hidden' name='buyingId' value='" + id + "'>");
  newWindow.document.write("<label for='date'>날짜:</label>");
  newWindow.document.write("<input type='date' id='date' name='date'><br><br>");
  newWindow.document.write("<label for='content'>내용:</label><br>");
  newWindow.document.write("<textarea id='content' name='content' style='width: 300px; height: 200px;'></textarea><br>");
  newWindow.document.write("<input type='submit' value='예약 제출'>");
  newWindow.document.write("</form></div>");
  newWindow.document.write("</body></html>");
  newWindow.document.close();

  // 폼 제출 이벤트 추가
  $(newWindow.document).find('#reservationForm').submit(function(e) {
    e.preventDefault();

    let formData = $(this).serialize();
    $.ajax({
      type: 'POST',
      url: '/HumanRental/reservation/buying',
      data: formData,
      success: function(response) {
        // 서버로부터의 응답을 처리합니다.
        // 예를 들어, 서버에서 반환한 페이지를 로드합니다.
        window.location.href = response.redirectUrl;
      },
      error: function(error) {
        // 에러를 처리합니다.
        console.error(error);
      }
    });
  });
}
