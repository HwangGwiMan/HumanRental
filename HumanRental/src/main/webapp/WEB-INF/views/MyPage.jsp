<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이 페이지</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
	</head>
	<body>
		<jsp:include page="nav.jsp" />
		<div class="container">
			<div class="row">
				<div class="col-2">
					<ul class="row">
						<li class="btn">마이 페이지</li><!-- 기본값 -->
						<li class="btn">회원 정보 수정</li>
						<li class="btn">프로필 수정
							<ul>
								<li>멘토 프로필 수정</li>
								<li>멘티 프로필 수정</li>
							</ul><!-- 삽니다 팝니다 하위 목록 -->
						</li>
						<li class="btn">멘티 프로필 수정</li>
						<li class="btn">예약 목록
							<ul>
								<li>삽니다 예약 목록</li>
								<li>팝니다 예약 목록</li>
							</ul><!-- 삽니다 팝니다 하위 목록 -->
						</li>
						<li class="btn">일정 정보</li>
						<li class="btn">회원 탈퇴</li>
					</ul>
				</div>
				<div class="col">
					<div class="row">
						<div class="col-4">
							<div class="row"><img src="<c:url value="/resources/img/ProfilePicture/${ image }" />"></div>
							<div class="row">파일 업로드</div>
						</div>
						<div class="col">test2</div>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
	</body>
</html>