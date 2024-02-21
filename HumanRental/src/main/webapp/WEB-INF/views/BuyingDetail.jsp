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
			
			<c:set var="buying" value="${buying}" />
			
				<div class="left col-6">
					<div class="img">이미지</div>
				</div>
				<div class="col-6">
					<div class="info">
						<div>
							<h2>${buying.title}</h2>
							<h5>${buying.regist_day}</h5>
							<br>
							<h4>${buying.nickname} 
							<span>
							<c:choose>
								<c:when test="${buying.starRate==0}">☆☆☆☆☆</c:when>
								<c:when test="${buying.starRate==1}">★☆☆☆☆</c:when>
								<c:when test="${buying.starRate==2}">★★☆☆☆</c:when>
								<c:when test="${buying.starRate==3}">★★★☆☆</c:when>
								<c:when test="${buying.starRate==4}">★★★★☆</c:when>
								<c:when test="${buying.starRate==5}">★★★★★</c:when>
							</c:choose>
							</span></h4>
							<br>
							<p>${buying.content}</p>
							<br>
						</div>
						<div class="qq">
							<h4>시간당 ${buying.price}원</h4>
							<c:set var="sessionId" value="${sessionScope.user}" />
							<c:choose>
								<c:when test="${sessionId==buying.memberId}">
									<div class="box1"><a href="<c:url value="/buying/delete?buyingId=${buying.buyingId}"/>">삭제</a></div>
									<div class="box2"><a href="<c:url value="/buying/update?buyingId=${buying.buyingId}"/>">수정</a></div>
									
								</c:when>
								<c:otherwise>
									<div class="box1"><a href="<c:url value="/reservation/create?buyingId=${buying.buyingId}"/>">신청하기</a></div>
									<div class="box2"><a href="<c:url value="/buying/update?buyingId=${buying.buyingId}"/>">찜하기</a></div>
								</c:otherwise>
							</c:choose>
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