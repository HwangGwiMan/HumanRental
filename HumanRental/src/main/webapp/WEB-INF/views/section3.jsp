<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_section3.css"/>">
 </head>

<body>
	<div class="qqs3 container">
        <div class="info text-center fs-1 p-5">
            <div class="fw-semibold">최신 리뷰</div>
        </div>
        <div class="row d-flex justify-content-evenly">
        <c:forEach var="review" items="${reviewlist}">
	        <div class="box2 rounded-3">
				<div class="card-info">
					<div class="review">
						<div>
							<h3 class="fs-4 pt-2">${review.title}</h3>
							<h4 class="fs-6">${review.nickname}</h4>
						</div>
					</div>
					<div class="date">
						<span class="fs-4">
							<c:choose>
							    <c:when test="${review.starRate==0}"><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate==1}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate==2}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate==3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate==4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate==5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></c:when>
							    <c:when test="${review.starRate > 0 && review.starRate < 1}"><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate > 1 && review.starRate < 2}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate > 2 && review.starRate < 3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate > 3 && review.starRate < 4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i></c:when>
							    <c:when test="${review.starRate > 4 && review.starRate < 5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i></c:when>
								<c:otherwise>
								<i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i>
								</c:otherwise>
							</c:choose>
						</span>
					</div>
				</div>
				<div>
					<hr>
					<div class="content">
						${review.content}
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
    </div>
</body>
</html>