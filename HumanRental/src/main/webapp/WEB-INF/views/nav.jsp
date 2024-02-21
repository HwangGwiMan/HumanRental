<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_nav.css"/>">
		
		<!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	    
		<script src="<c:url value="/resources/js/nav.js"/>"></script>
	</head>
	<body>
		<nav class="qqnav container">
			<div class="row d-flex align-items-center justify-content-between">
				<div class="col-5 d-flex align-items-center qq1">
					<a href="<c:url value="/main"/>"><h4>휴먼렌탈</h4></a>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link" href="#">재능기부</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/BuyingList"/>">멘티구함</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/mentorlist"/>">멘토구함</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/board"/>">커뮤니티</a></li>
					</ul>
				</div>
				<div class="col-4">
					<form class="form-inline d-flex mx-auto" action="<c:url value="/SearchPage"/>">
						<input class="form-control mr-2" type="text" placeholder="어떤 멘토를 찾으세요?">
						<button class="btn btn-primary" type="submit"> <i class="fa-solid fa-magnifying-glass"></i></button>
					</form>
				</div>
				<div class="col-3">
					<ul class="nav justify-content-end position-relative">
						<% if(request.getSession().getAttribute("user") != null) { %>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/myInfo?mode=myPage"/>">MY</a></li>
						<% } else {	%>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>">로그인</a></li>
						<% } %>
						<li class="nav-item"><a class="nav-link" href="#">찜목록</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/mentorIntro"/>">멘토신청</a></li>
						<li class="nav-item">
							<a class="nav-link" href="#" id="alarmBtn">
								<i class="fa-regular fa-bell position-relative">
									<c:if test="${ not empty alarmList }">
										<span class="position-absolute badge top-0 start-100 translate-middle bg-danger rounded-circle p-1">
											<span class="visually-hidden">new Alarm</span>
										</span>
									</c:if>
								</i>
							</a>
							<div class="position-absolute end-0 alert alert-primary col" style="display: none;">
								<c:choose>
									<c:when test="${ empty alarmList }">
										알람이 없습니다.
									</c:when>
									<c:when test="${ not empty alarmList }">
										<c:forEach var="alarm"  items="${ alarmList }" varStatus="status">
											<div>
												<div>
													<a href="#" class="row btn">
														<div class="col">
															<c:choose>
																<c:when test="${ fn:contains(alarm.alarmId , 'mentoApplyAlarm') }">
																	<div class="row">멘토 신청 알림</div>
																	<div class="row">사용자 님이 멘토 신청을 하셨습니다.</div>
																</c:when>
															</c:choose>
															${ duration.get(status.index).getSeconds() }
															<div class="row">2024 / 2 / 16 (10초 전)</div>
														</div>
													</a>
												</div>
												<div class="justify-content-center">
													<a href="#" class="row btn">x</a>
												</div>
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