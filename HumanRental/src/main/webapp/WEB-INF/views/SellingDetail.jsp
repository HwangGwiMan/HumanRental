<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_menteeDetail.css"/>">

<script>
	function showCalendar() {
	    var calendarForm = document.getElementById("calendarForm");
	    if (calendarForm.style.display === "none") {
	        calendarForm.style.display = "block";
	    } else {
	        calendarForm.style.display = "none";
	    }
	}
</script>
<script src="<c:url value="/resources/js/save.js"/>"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="detail container">
		<div class="row">
			<div class="top d-flex">
			
			<c:set var="selling" value="${selling}" />
			
				<div class="left col-6">
					<div class="img">이미지</div>
				</div>
				<div class="col-6">
					<div class="info">
						<div>
							<h2>${selling.title}</h2>
							<h5>${selling.regist_day}</h5>
							<br>
							<h4>${selling.nickname} 
							<span>
								<c:choose>
								    <c:when test="${selling.starRate==0}"><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate==1}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate==2}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate==3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate==4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate==5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></c:when>
								    <c:when test="${selling.starRate > 0 && selling.starRate < 1}"><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate > 1 && selling.starRate < 2}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate > 2 && selling.starRate < 3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate > 3 && selling.starRate < 4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${selling.starRate > 4 && selling.starRate < 5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i></c:when>
									<c:otherwise>
									<i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i>
									</c:otherwise>
								</c:choose>
							</span>
							</h4>
							<br>
							<p>${selling.content}</p>
							<br>
						</div>
						<div class="qq">
							<h4>시간당 ${selling.price}원</h4>
							<c:set var="sessionId" value="${sessionScope.user}" />
							<c:choose>
								<c:when test="${sessionId==selling.memberId}">
									<div class="box1"><a href="<c:url value="/selling/delete?sellingId=${selling.sellingId}"/>">삭제</a></div>
									<div class="box2"><a href="<c:url value="/selling/update?sellingId=${selling.sellingId}"/>">수정</a></div>
								</c:when>
								<c:otherwise>
									<div class="box1">
									    <a href="javascript:void(0)" onclick="showCalendar()">신청하기</a>
									</div>
									<div id="calendarForm" class="calendarForm" style="display: none;">
										<form:form action="../reservation/selling?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
											<input name="sellingId" type="hidden" value="${selling.sellingId}">
									    	예약일 : <input name="date" type="date" class="date" required>
									    	<br><br>
									    	예약 상세 내용 : <textarea name="content" cols="50" rows="5" class="form-control" required placeholder="오후 7시부터 2시간 예약하고 싶어요"></textarea>
									    	<input type="submit" value="제출">
										</form:form>
									</div>
									<div class="box2">
    									<a href="javascript:void(0);" onclick="saveCheck(event, this)" data-id="${selling.sellingId}">찜하기</a>
									</div>									
									<%-- <div class="box2"><a href="<c:url value="/save/saveinsert?savelistId=${selling.sellingId}"/>">찜하기</a></div> --%>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
			<div class="bot col-12">
				<div class="box1">
					<h2>
						후기 <span class="star1">★★★☆☆</span>
					</h2>
				</div>
				<div class="box2">
					<div class="card-info">
						<div class="review">
							<div>
								<h4>
									배움의 자세가 좋습니다 <span class="star2">★★★★★</span>
								</h4>
							</div>
						</div>
						<div class="date">
							<div>김멘토 | 2024.05.05</div>
						</div>
					</div>
					<div>
						<hr>
						<div class="content">
							<p>
								성실하게 임하는 모습 좋아요
							</p>
						</div>
					</div>
					<div class="line"></div>
					<div class="card-info">
						<div class="review">
							<div>
								<h4>
									쓰레기입니다 <span class="star2">★☆☆☆☆</span>
								</h4>
							</div>
						</div>
						<div class="date">
							<div>이멘토 | 2024.04.05</div>
						</div>
					</div>
					<div>
						<hr>
						<div class="content">
							<p>배움의 자세가 없음</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>