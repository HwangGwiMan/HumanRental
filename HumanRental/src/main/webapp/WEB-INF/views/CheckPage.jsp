<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<style type=""></style>
<title>Board</title>
<script>
   function goBack() {
       // 브라우저의 이전 페이지로 이동
       history.back();
   }
</script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row">
			<c:choose>
				<c:when test="${ mode == 'reservation' }">
					<h2 class='alert alert-success'>예약 신청이 성공적으로 되었습니다.</h2>
					<div>
						<table class="table table-hover">
							<tr>
								<th>예약 번호</th>
								<th>제목</th>
								<th>멘토</th>
								<th>멘티</th>
								<th>예약일</th>
								<th>예약 상세 내용</th>
							</tr>			
							<tr>
								<td>${ reservation.reservationId }</td>
								<td>${ reservation.title }</td>
								<td>${ reservation.mentorId }</td>
								<td>${ reservation.menteeId }</td>
								<td>${ reservation.reservationdate }</td>
								<td class="col-5">${ reservation.reservationcontent }</td>
							</tr>
						</table>
					</div>
				</c:when>
			</c:choose>
			<div style="text-align: center;"><input type="reset" class="btn btn-primary" value="돌아가기" onclick="goBack()"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
