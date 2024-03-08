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
		
		<!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		
		<script src="<c:url value="/resources/js/MentorIntro.js"/>"></script>
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container pt-5 mt-5">
			<div class="row justify-content-center p-5 fs-1">멘토 신청 안내</div>
			<div class="row justify-content-center p-5 fs-3">
				다양한 분야에서 멘토가 될 수 있는 분들을 모집합니다.<br>
				자신만의 재능을 유용하게 활용하고 싶은 분들은 멘토가 되어 활동해 보세요.<br>
			</div>
			<div class="row justify-content-center p-5">
				<div class="col-sm-2 btn btn-secondary fs-4 text-nowrap" onclick="javascript:mentorCheck()">멘토 신청</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>