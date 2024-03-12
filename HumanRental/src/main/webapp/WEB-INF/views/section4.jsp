<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/style_section4.css"/>">
<script src="<c:url value="/resources/js/main.js"/>"></script>
</head>

<body>
	<div class="service">
		<div class="left p-5">
			<h1 class="fw-semibold">Category</h1>
		</div>
		<div class="right">
			<div>
				<i class="fa-solid fa-guitar"></i>
				<h4>Music</h4>
				<p>음악은 우리의 삶을 더욱 풍요롭게 만들어줍니다.</p>
				<a href="#" category="music" onclick="goSelling(this)">Read More</a>
			</div>
			<div>
				<i class="fa-solid fa-person-running"></i>
				<h4>Sports</h4>
				<p>건강을 챙기며 즐거움을 느낄 수 있는 다양한 운동 활동을 찾아보세요. </p>
				<a href="#" category="sports" onclick="goSelling(this)">Read More</a>
			</div>
			<div>
				<i class="fa-solid fa-gamepad"></i>
				<h4>Game</h4>
				<p>현실에서 벗어나 새로운 세계로 떠나는 특별한 모험을 만나보세요.</p>
				<a href="#" category="game" onclick="goSelling(this)">Read More</a>
			</div>
			<div>
				<i class="fa-solid fa-comments"></i>
				<h4>Study</h4>
				<p>지식을 나누며 성장할 수 있는 특별한 기회를 찾아보세요.</p>
				<a href="#" category="study" onclick="goSelling(this)">Read More</a>
			</div>
		</div>
	</div>
</body>
</html>