<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_mentorlist.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/style_menteelist.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/style_SearchPage.css"/>">
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="qqml container">
		<div class="category">
			<div>
				<i class="fa-solid fa-guitar"></i>
			</div>
			<div>
				<i class="fa-solid fa-person-running"></i>
			</div>
			<div>
				<i class="fa-solid fa-gamepad"></i>
			</div>
			<div>
				<i class="fa-solid fa-comments"></i>
			</div>
			<div>
				<i class="fa-solid fa-truck"></i>
			</div>
			<div>
				<i class="fa-solid fa-hammer"></i>
			</div>
			<div>
				<i class="fa-solid fa-book-open"></i>
			</div>
			<div>
				<i class="fa-solid fa-car"></i>
			</div>
		</div>
		<div class="search container">
			<div class="row">
				<div class="qqml mentor">
					<div class="top">멘토 리스트</div>
					<div class="bot row">
						<div class="qq2 col-4">
							<div class="wrapper">
								<div class="image-wrapper">
                        			<img src="/HumanRental/resources/image/duke.png"/>
									<h1 class="name">이름</h1>
									<p class="description">프로그래밍 | 뭐시기 | 저시기</p>
									<br>
									<p class="information">
										경력 78년의 개씹풀스택 개발자 <br> 시키면 다 합니다
									</p>
									<br> <a href="#" target="_blank" class="follow">신청하기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="qqml2 mentee">
					<div class="top">멘티 리스트</div>
					<div class="bot row">
						<div class="qq2 col-3">
							<div class="wrapper">
								<div class="image-wrapper">
									<i class="fa-solid fa-guitar"></i> <br>
									<br>
									<p class="information">
										매주 토요일 오후 4시 <br> 기타 알려주실분~
									</p>
									<br> <a href="#" target="_blank" class="follow">신청하기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="qqml3 mentee">
					<div class="top">후기 리스트</div>
					<div class="bot row">
						<div class="qq2 col-3">
							<div class="wrapper">
								<div class="image-wrapper">
									<h4>클래스 이름</h4>
									<br>
									<p>매우 잘 알려줌니다</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>