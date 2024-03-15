<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_buyingDetail.css"/>">
<script src="<c:url value="/resources/js/buying.js"/>"></script>
<script src="<c:url value="/resources/js/save.js"/>"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="detail container">
		<div class="row">
			<div class="top d-flex">
			<c:set var="buying" value="${buying}" />
				<div class="left col-6">
					<div class="img">
						<img alt="" src="">
					</div>
				</div>
				<div class="col-6">
					<div class="info">
						<div>
							<h2 style="font-size: 3vh">${buying.title}</h2>
							<h5 style="font-size: 1.5vh">${buying.regist_day}</h5>
							<br>
							<h4 style="font-size: 2vh">${buying.nickname} 
							<span>
								<c:choose>
								    <c:when test="${buying.starRate==0}"><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate==1}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate==2}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate==3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate==4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate==5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></c:when>
								    <c:when test="${buying.starRate > 0 && buying.starRate < 1}"><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate > 1 && buying.starRate < 2}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate > 2 && buying.starRate < 3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate > 3 && buying.starRate < 4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i></c:when>
								    <c:when test="${buying.starRate > 4 && buying.starRate < 5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i></c:when>
									<c:otherwise>
									<i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i>
									</c:otherwise>
								</c:choose>
							</span>
							</h4>
							<br>
							<pre style="font-size: 1.8vh; white-space: break-spaces">${buying.content}</pre>
							<br>
						</div>
						<div class="qq">
							<div>
								<h2 style="font-size: 1.5vh">활동 지역 : ${buying.location}</h2>
								<h4 style="font-size: 2vh">시간당 ${buying.price}원</h4>
							</div>
							<c:set var="sessionId" value="${sessionScope.user}" />
							<c:choose>
							<c:when test="${sessionId==buying.memberId}">
								<div class="d-flex">
									<div class="box2 btn btn-dark" onclick="updateBuying(this)" boradId="${buying.buyingId}">수정</div>
									<div class="box1 btn btn-dark" onclick="deleteBuying(this)" boradId="${buying.buyingId}">삭제</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="d-flex">
									<div class="box1 btn btn-dark btn-lg" onclick="showCalendar()">신청하기</div>
									<div id="calendarForm" class="calendarForm" style="display: none;">
										<form:form action="../reservation/buying?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
											<input name="buyingId" type="hidden" value="${buying.buyingId}">
									    	예약일 : <input name="date" type="date" class="date" required>
									    	<br><br>
									    	예약 상세 내용 : <textarea name="content" cols="50" rows="5" class="form-control" required placeholder="오후 7시부터 2시간 예약하고 싶어요"></textarea>
									    	<input type="submit" value="제출">
										</form:form>
									</div>
							 		<div class="box2 btn btn-dark btn-lg" onclick="saveCheck(event, this)" data-id="${buying.buyingId}">찜하기</div>
						 		</div>
							</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
			<div class="bot col-12">
				<div class="box1 d-flex align-items-center text-white bg-black bg-gradient">
					<h2>
						후기 
						<span>
							<c:choose>
							    <c:when test="${buying.starRate==0}"><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate==1}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate==2}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate==3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate==4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate==5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></c:when>
							    <c:when test="${buying.starRate > 0 && buying.starRate < 1}"><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate > 1 && buying.starRate < 2}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate > 2 && buying.starRate < 3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate > 3 && buying.starRate < 4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${buying.starRate > 4 && buying.starRate < 5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i></c:when>
								<c:otherwise>
								<i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i>
								</c:otherwise>
							</c:choose>
						</span>
						<qwer style="font-size: 2vh;">(${buying.starCount})</qwer>
					</h2>
				</div>
				<c:forEach items="${reviewList}" var="review">
				<div class="box2">
					<div class="card-info">
						<div class="review">
							<div>
								<h4>
									${review.title} 
									<span>
										<c:choose>
										    <c:when test="${review.starRate==0}"><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate==1}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate==2}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate==3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate==4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate==5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></c:when>
										    <c:when test="${review.starRate > 0 && review.starRate < 1}"><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate > 1 && review.starRate < 2}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate > 2 && review.starRate < 3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate > 3 && review.starRate < 4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i></c:when>
										    <c:when test="${review.starRate > 4 && review.starRate < 5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i></c:when>
											<c:otherwise>
											<i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i>
											</c:otherwise>
										</c:choose>
									</span>
								</h4>
							</div>
						</div>
						<div class="date">
							<div>${review.nickname} | ${review.writeDate}</div>
						</div>
					</div>
					<div>
						<hr>
						<div class="content">
							<pre style="white-space: break-spaces;">${review.content}</pre>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>