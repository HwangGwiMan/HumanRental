<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>휴먼 렌탈</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_nav.css"/>">
		<link rel="stylesheet" href="<c:url value="/resources/css/Main.css"/>">
	</head>
	<body>
		<jsp:include page="nav.jsp" />
<<<<<<< HEAD
		<div class="container pt-3">
			<div class="row">
				<div class="info">당신의 재능을 나누세요. + 장황한 말</div>
			</div>
		</div>
		<div class="container pt-5">
	        <div class="row">
	            <div class="col-8 align-self-center d-flex justify-content-center">
	                <div class="slide">
	                    대충 슬라이드 드가는 부분
	                </div>
	            </div>
	            <div class="col-4">
	                <div class="row row-cols-2">
	                    <div class="col">
	                        <div class="box">
	                            <div class="border">
	                                <i class="fas fa-music"></i>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col">
	                        <div class="box">
	                            <div class="border">
	                                <i class="fas fa-music"></i>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col">
	                        <div class="box">
	                            <div class="border">
	                                <i class="fas fa-music"></i>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col">
	                        <div class="box">
	                            <div class="border">
	                                <i class="fas fa-music"></i>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col">
	                        <div class="box">
	                            <div class="border">
	                                <i class="fas fa-music"></i>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col">
	                        <div class="box">
	                            <div class="border">
	                                <i class="fas fa-music"></i>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col">
	                        <div class="box">
	                            <div class="border">
	                                <i class="fas fa-music"></i>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
		<div class="container">
	        <div class="row justify-content-center">
		        <div class="text-center fs-1 p-5">
		            <div class="p-3">멘티 모집</div>
		        </div>
		        <div class="row">
					<c:forEach var="selling" items="${ sellinglist }">
			            <div class="col-4 p-3">
			                <div class="d-flex justify-content-center border ">
			                    <div style="width: 50%;">
			                        <img src="/HumanRental/resources/image/duke.png" alt="">
			                    </div>
			                    <div class="align-self-center" style="width: 50%;">
			                        <div>${ selling.nickname }</div>
			                        <div>${ selling.title }</div>
			                    </div>
			                </div>
			            </div>
		            </c:forEach>
		        </div>
	    	</div>
	    </div>
		<div class="container">
			<div class="row justify-content-center">
		        <div class="text-center fs-1 p-5">
		            <div class="p-3">멘토 모집</div>
		        </div>
		        <div class="row">
					<c:forEach var="buying" items="${ buyinglist }">
			            <div class="col-4 p-3">
			                <div class="d-flex justify-content-center border">
			                    <div class="align-self-center">
			                        <div>${ buying.nickname }</div>
			                        <div>${ buying.title }</div>
			                    </div>
			                </div>
			            </div>
		            </c:forEach>
		        </div>
	        </div>
    	</div>
=======
		<jsp:include page="section0.jsp" />
		<br>
		<jsp:include page="section1.jsp" />
		<jsp:include page="section2.jsp" />
		<jsp:include page="section3.jsp" />
>>>>>>> refs/heads/main
		<jsp:include page="footer.jsp" />
	</body>
</html>