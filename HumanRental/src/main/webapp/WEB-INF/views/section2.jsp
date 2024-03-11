<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_section2.css"/>">
<script src="<c:url value="/resources/js/main.js"/>"></script>

</head>

<body>
	<div class="qqs2 container">
        <div class="row justify-content-center p-5">
	        <div class="info text-center">
	            <div class="p-5 fw-semibold">Best Mentor</div>
	        </div>
	        <div class="row">
		        <div class="qq0">
				<c:forEach var="mentor" items="${mentorlist}" varStatus="loop">
				    <c:if test="${loop.index < 3}">
			            <div class="qq1 text-bg-light">
							<div class="top text-center">
								<img src="/HumanRental/resources/img/Main/teacher1.png" alt=""
									class="img-fluid">
							</div>
							<div class="bot text-center">
			                    <div class="nickname">${mentor.nickname}</div>
			                    <div class="category">
				                    <c:forEach var="category" items="${fn:split(mentor.category, ',')}">
										<span class="badge text-bg-primary">${category}</span>
									</c:forEach>
			                    </div>
			                </div>
			            </div>
				    </c:if>
				</c:forEach>
				</div>
	        </div>
    	</div>
    </div>
</body>
</html>