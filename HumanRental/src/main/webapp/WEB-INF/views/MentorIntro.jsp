<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멘토 신청</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		
		<link rel="stylesheet" href="<c:url value="/resources/css/style_mentorIntro.css"/>">
		
		<!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		
		<script src="<c:url value="/resources/js/MentorIntro.js"/>"></script>
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="content d-flex flex-column justify-content-evenly">
			<div class="row justify-content-center p-5 fs-1 text">멘토 신청 안내</div>
			<div class="row justify-content-center p-5 fs-3 text">
				다양한 분야에서 멘토가 될 수 있는 분들을 모집합니다.<br>
				자신만의 재능을 유용하게 활용하고 싶은 분들은 멘토가 되어 활동해 보세요.<br>
			</div>
			<div class="row justify-content-center p-5 text">
				<div class="col-sm-2 btn btn-outline-dark btn-light fs-5 " onclick="javascript:mentorCheck()">멘토 신청</div>
			</div>
		</div>
	    <div class="foot border-top">
	        <div>
	            <span>휴먼렌탈</span>, 세상을 바꾸는 힘.
	        </div>
	        <div>
	            Produced by Team3
	        </div>
	    </div>
	</body>
</html>