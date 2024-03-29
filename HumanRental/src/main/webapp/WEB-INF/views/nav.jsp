<%-- <%@page import="java.time.Duration"%> --%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_nav.css"/>">
		
		<!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	    
	    <!-- WebSocket -->
	    <!-- <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script> -->
	    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	    
		<script src="<c:url value="/resources/js/nav.js"/>"></script>
		<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-barun-gothic.css" rel="stylesheet">
	</head>
	<body>
		<nav class="qqnav border-bottom">
			<div class="d-flex align-items-center justify-content-center">
				<div class="left d-flex align-items-center qq1">
					<div class="logo" onclick="goMain()"></div>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link" href="#">재능기부</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/BuyingList?pageNum=1"/>">재능구매</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/SellingList?pageNum=1"/>">재능판매</a></li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="<c:url value="/board"/>" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> 커뮤니티 </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="<c:url value="/board"/>">자유게시판</a>
								<a class="dropdown-item" href="<c:url value="/board2"/>">공지사항</a>
							</div>
						</li>
					</ul>
				</div>
				<div class="cen">
					<div style="width: 100%; height: 38px">
    					<form id="searchForm" class="form-inline d-flex mx-auto align-items-center" action="<c:url value='/Search'/>" method="get">
        					<select name="items" class="txt border-end">
					            <option value="all">전체</option>
					            <option value="title">제목</option>
					            <option value="content">내용</option>
					            <option value="nickname">닉네임</option>
        					</select> 
        					<input class="form-control search" type="text" name="search" placeholder="어떤 멘토,멘티를 찾으세요?" required>
        					<button class="btn btn-primary ms-1" type="submit"> <i class="fa-solid fa-magnifying-glass"></i></button>
    					</form>
					</div>
				</div>
				<div class="right">
					<ul class="nav justify-content-end position-relative">
						<% if(request.getSession().getAttribute("user") != null) { %>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/myInfo?mode=myPage"/>">MY</a></li>
						<% } else {	%>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>">로그인</a></li>
						<% } %>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/save/saveread"/>">찜목록</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/mentorIntro"/>">멘토신청</a></li>
						<li class="nav-item d-flex flex-column justify-content-center">
							<a class="nav-link" href="#" id="alarmBtn">
								<i class="fa-regular fa-bell position-relative">
									<c:if test="${ not empty alarmList }">
										<span class="position-absolute badge top-0 start-100 translate-middle bg-danger rounded-circle p-1" id="alarmLight">
											<span class="visually-hidden">new Alarm</span>
										</span>
									</c:if>
								</i>
							</a>
							<div class="z-3 position-absolute top-100 end-0 alert alert-dark col" style="display: none; width: 300px;">
								<c:choose>
									<c:when test="${ empty alarmList }">
										알람이 없습니다.
									</c:when>
									<c:when test="${ not empty alarmList }">
										<c:forEach var="alarm"  items="${ alarmList }" varStatus="status">
											<div id="alarmRow_${ alarm.alarmId }" class="row justify-content-center">
												<div class="row justify-content-center">
													<c:choose>
														<c:when test="${ fn:contains(alarm.alarmId , 'mentorApplyAlarm') }">
															<a href="<c:url value="/myInfo?mode=applyInfo&id=${ alarm.linkId }"/>" class="row btn">
																<div class="row">멘토 신청 알림</div>
																<div class="row text-nowrap">${ alarm.content }</div>
															</a>
														</c:when>
														<c:when test="${ fn:contains(alarm.alarmId , 'mentorApplyResultAlarm') }">
															<div class="row">멘토 신청 결과 알림</div>
															<div class="row">${ alarm.content }</div>
														</c:when>
														<c:when test="${ fn:contains(alarm.alarmId , 'warningAlarm') }">
															<div class="row">이용 경고 알림</div>
															<div class="row">${ alarm.content }</div>
														</c:when>
														<c:when test="${ fn:contains(alarm.alarmId , 'ReservationApplyAlarm') }">
															<a href="<c:url value="/reservationInfo?reservationId=${ alarm.linkId }"/>" class="row btn">
																<div class="row">재능 거래 신청 알림</div>
																<div class="row">${ alarm.content }</div>
															</a>
														</c:when>
														<c:when test="${ fn:contains(alarm.alarmId , 'ReservationConfirmAlarm') }">
															<a href="<c:url value="/reservationInfo?reservationId=${ alarm.linkId }"/>" class="row btn">
																<div class="row">재능 거래 승인 알림</div>
																<div class="row">${ alarm.content }</div>
															</a>
														</c:when>
													</c:choose>
													
													<div class="row">${ alarmTime.get(status.index) } (${ duration.get(status.index) })</div>
												</div>
												<div class="row justify-content-center">
													<a onclick="javascript:alarmDelete('${ alarm.alarmId }')"  class="col btn">x</a>
												</div>
												<hr>
											</div>
										</c:forEach>
									</c:when>
								</c:choose>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</body>
</html>