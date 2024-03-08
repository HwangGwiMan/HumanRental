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
	href="<c:url value="/resources/css/style_section1.css"/>">
</head>

<body>
	<div class="section1">
		<div class="wrap">
			<header>
				<label for="slide-1-trigger">재능 구매</label> <label
					for="slide-2-trigger">재능 판매</label> <label for="slide-3-trigger">재능
					기부</label>
			</header>
			<input id="slide-1-trigger" type="radio" name="slides" checked>
			<section class="slide slide-one">
				<div class="info">
					<div class="left">
						<h1>
							<b>재능 구매</b>
						</h1>
						<p>
							"열정적인 학습자들을 위한 지식의 문이 열립니다.<br> 새로운 세계를 탐험하고, 무한한 배움의 가능성을
							찾아보세요."
						</p>
					</div>
					<div class="right">
						<div class="img1"></div>
					</div>
				</div>
			</section>
			<input id="slide-2-trigger" type="radio" name="slides">
			<section class="slide slide-two">
				<div class="info">
					<div class="left">
						<h1>
							<b>재능 판매</b>
						</h1>
						<p>
							"내가 가진 지식과 경험을 나누어 보세요.<br> 다른 이들에게 가르침과 영감을 전달해보세요."
						</p>
					</div>
					<div class="right">
						<div class="img2"></div>
					</div>
				</div>
			</section>
			<input id="slide-3-trigger" type="radio" name="slides">
			<section class="slide slide-three">
				<div class="info">
					<div class="left">
						<h1>
							<b>재능 기부</b>
						</h1>
						<p>
							"나눔의 소중함을 느끼고,<br> 함께 세상을 더 아름답게 만들어 나가는 데 동참해 주세요."
						</p>
					</div>
					<div class="right">
						<div class="img3"></div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<script>
	let currentSlide = 1;
	const totalSlides = 3;

	function nextSlide() {
		  const nextIndex = currentSlide % totalSlides + 1;
		  const triggerId = "slide-" + nextIndex + "-trigger";
		  const triggerElement = document.getElementById(triggerId);
		  if (triggerElement) {
		    triggerElement.checked = true;
		    currentSlide = nextIndex;
		  }
		}

	setInterval(nextSlide, 15000);
	</script>
</body>
</html>