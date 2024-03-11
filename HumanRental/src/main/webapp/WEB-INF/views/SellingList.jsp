<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<title>휴먼렌탈</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_mentorlist.css"/>">
		<script src="<c:url value="/resources/js/myPage.js"/>"></script>
	</head>
	
	<body>
		<jsp:include page="nav.jsp" />
		<div class="qqml container">
	        <div class="text-center fs-1 p-3">
	            <div class="p-3">멘티 모집</div>
	        </div>
	        <div class="category pt-3">
	            <div class="btn btn-light fs-1"><a href="<c:url value="/SellingList?category=music"/>"><i class="fa-solid fa-guitar"></i></a></div>
	            <div class="btn btn-light fs-1"><a href="<c:url value="/SellingList?category=sports"/>"><i class="fa-solid fa-person-running"></i></a></div>
	            <div class="btn btn-light fs-1"><a href="<c:url value="/SellingList?category=game"/>"><i class="fa-solid fa-gamepad"></i></a></div>
	            <div class="btn btn-light fs-1"><i class="fa-solid fa-comments"></i></div>
	            <div class="btn btn-light fs-1"><i class="fa-solid fa-car"></i></div>
	<!--             <div><i class="fa-solid fa-hammer"></i></div> -->
	            <div class="btn btn-light fs-1"><i class="fa-solid fa-book-open"></i></div>
	            <div class="btn btn-light"><a href="<c:url value="/SellingList"/>" class="fs-4 text-decoration-none">전체</a></div>
	            <div class="btn fs-1"><a onclick="mentorCheck2()" class="fs-4 text-decoration-none">쓰기</a></div>
	            
	        </div>
	        <div class="qq1 row">
		        <c:forEach items="${sellinglist}" var="selling">
		            <div class="qq2 col-3">
		                <div class="wrapper border" onclick="menteeCheck(this)" data-selling-id="${selling.sellingId}">
		                    <div class="image-wrapper">
		                    	<!-- <img src="/HumanRental/resources/image/duke.png"/> -->
		                    	<div>
		                    	<c:choose>
		                    	<c:when test="${selling.category eq 'music'}">
		                        	<i class="fa-solid fa-guitar fs-1"></i>
		                        </c:when>
		                        <c:when test="${selling.category eq 'sports'}">
		                        	<i class="fa-solid fa-person-running fs-1"></i>
		                        </c:when>
		                        <c:when test="${selling.category eq 'game'}">
		                        	<i class="fa-solid fa-gamepad fs-1"></i>
		                        </c:when>
		                        </c:choose>
		                        </div>
		                        <div>
		                        	<h1 class="name fs-5">${selling.title}</h1>
		                        </div>
		                        <div>
									<a href="<c:url value='/mentorprofilepage?nickname=${selling.nickname}'/>" class="text-decoration-none">${selling.nickname}</a>
								</div>
								<!-- <div>
		                        	<p class="information">간단한 내용(한줄)</p>
		                        </div> -->
		                        <div>
	<%-- 	                        <a href='<c:url value="/selling/detail?sellingId=${selling.sellingId}"/>' class="follow">신청하기</a> --%>
		                        	<%-- <a onclick="menteeCheck(this)" data-selling-id="${selling.sellingId}" class="follow btn btn-secondary">신청하기</a> --%>
		                        </div>
		                    </div>
		                </div>
		            </div>
		         </c:forEach>
	        </div>
	    </div>
		<jsp:include page="footer.jsp" />
		<script type="text/javascript">
		
		</script>
	</body>
</html>