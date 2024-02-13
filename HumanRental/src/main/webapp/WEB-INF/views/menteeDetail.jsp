<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_menteeDetail.css"/>">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="detail container">
		<div class="row">
			<div class="top d-flex">
				<div class="left col-6">
					<div class="img">이미지</div>
				</div>
				<div class="col-6">
					<div class="info">
						<div>
							<h2>풀스택 개발자님 구해요</h2>
							<h5>2024.03.03</h5>
							<br>
							<h4>김멘티 <span>★★★☆☆</span></h4>
							<br>
							<p>코딩 기초부터 알려주실 멘토님 구해요~</p>
							<br>
						</div>
						<div class="qq">
							<h4>시간당 ~20000원</h4>
							<div class="box1">찜하기</div>
							<div class="box2">신청하기</div>
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