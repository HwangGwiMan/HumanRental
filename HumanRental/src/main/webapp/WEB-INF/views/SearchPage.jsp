<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<script src="<c:url value="/resources/js/myPage.js"/>"></script>
		<script src="<c:url value="/resources/js/buyingList.js"/>"></script>
		<script src="<c:url value="/resources/js/sellingList.js"/>"></script>
		 <link rel="stylesheet" href="<c:url value="/resources/css/style_buyingList.css"/>">		
</head>

<body>
	<jsp:include page="nav.jsp" />
	<br><br>
	<div style="width:80%; margin:0 auto;"> 
		<div class="qqml2 container">
			<div class="category col-12 d-flex justify-content-around align-items-center m-auto">
				<div class="bar">
					<a href="<c:url value="/BuyingList?pageNum=1"/>" class="text-decoration-none"><i class="fa-solid fa-a"></i><br><span>ALL</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/search?category=music"/>"><i class="fa-solid fa-music"></i><br><span>Music</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/BuyingList?category=sports"/>"><i class="fa-solid fa-person-running"></i><br><span>Sprots</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/BuyingList?category=game"/>"><i class="fa-solid fa-gamepad"></i><br><span>Game</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/BuyingList?category=study"/>"><i class="fa-solid fa-book-open"></i><br><span>Study</span></a>
				</div>
				<div class="bar"><a onclick="menteeCheck2()" class="text-decoration-none" style="cursor: pointer;"><i class="fa-solid fa-pen-to-square"></i><br><span>Write</span></a></div>
			</div>
			<br><br>
		<div class="search container">
		<div class="top">재능 판매</div>		
			<hr>
			<div class="container-fluid"> <!-- 컨테이너 설정 -->
				<div class="row"> <!-- 로우 설정 -->
					<c:forEach var="selling" items="${selling}" varStatus="status">
						<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12"> <!-- 컬럼 설정 -->
							<div class="mentor">
				                <div class="wrapper border" onclick="menteeCheck(this)" data-selling-id="${selling.sellingId}" style="height: 18vh;">
									<div class="image-wrapper h-100 d-flex flex-column">
										<div style="margin-top: 2vh;">
											<i class="fa-solid fa-gamepad" aria-hidden="true"></i>
										</div>
										<div class="d-flex flex-column justify-content-evenly" style="height: 100%;">
											<div>
												<h1 class="title">${selling.title}</h1>
											</div> 
											<div class="d-flex justify-content-between">
												<div class="text-start">
													<p class="description" style="font-size: 1.1em">${selling.nickname}</p>
													<p class="description" style="color: black;">${selling.category}</p>
												<%-- 	<p type="hidden" style="color: black;">${selling.content}</p> --%>
												</div>
													<div class="text-end">
											<span>
<!--  												    <i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i>
 --> 											</span> 
											(0)
	                                            <p class="description" style="color: black; font-size: 2.5vh;"> ${selling.price}원</p>
											</div>
											</div>
										</div>       
									</div>
								</div>
							</div>
						</div> 	
					</c:forEach>
				</div>   
			</div>
		<div class="row">
		<div class="d-flex flex-row justify-content-center">
		        <c:forEach var="pagenumbers2" items="${pagenumbers2}" varStatus="status"> 
		        	<div class="mx-2">             
		            <a  href="<c:url value='/Search?page=${pagenumbers2}&search=${search}'/>">${pagenumbers2}</a>
		            </div>
		        </c:forEach>
		    </div>
		</div>  
			<br><br>
			<div class="top">재능 구매</div>
			<hr>
			<div class="container-fluid"> <!-- 컨테이너 설정 -->
				<div class="row"> <!-- 로우 설정 -->
					<c:forEach var="buying" items="${buying}" varStatus="status">
						<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12"> <!-- 컬럼 설정 -->
							<div class="mentor">
				                <div class="wrapper border" onclick="mentorCheck(this)" data-buying-id="${buying.buyingId}" style="height: 18vh;">
									<div class="image-wrapper h-100 d-flex flex-column">
										<div style="margin-top: 2vh;">
											<i class="fa-solid fa-gamepad" aria-hidden="true"></i>
										</div>
										<div class="d-flex flex-column justify-content-evenly" style="height: 100%;">
											<div>
												<h1 class="title">${buying.title}</h1>
											</div> 
											<div class="d-flex justify-content-between">
												<div class="text-start">
													<p class="description" style="font-size: 1.1em">${buying.nickname}</p>
													<p class="description" style="color: black;">${buying.category}</p>
												</div>
													<div class="text-end">
											<span>
<!--  												    <i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i>
 --> 											</span> 
											(0)
	                                            <p class="description" style="color: black; font-size: 2.5vh;"> ${buying.price}원</p>
											</div>
											</div>
										</div>       
									</div>
								</div>
							</div>
						</div> 	
					</c:forEach>
				</div>   
			</div>
			<div class="row">
			<div class="d-flex flex-row justify-content-center">
		        <c:forEach var="pagenumbers" items="${pagenumbers}" varStatus="status"> 
		        	<div class="mx-2">             
		            <a  href="<c:url value='/Search?page=${pagenumbers}&search=${search}'/>">${pagenumbers}</a>
		            </div>
		        </c:forEach>
		    </div>
			</div>  	      
			<div class="top">멘토 리스트</div>
				<hr>
				<br>
				<div class="container-fluid"> <!-- 컨테이너 설정 -->
				    <div class="row">
				        <c:forEach var="mentorProfile" items="${mentorprofileAll}" varStatus="status">
							<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 mb-4"> <!-- mb-4를 mb-5로 변경하여 마진 바텀을 늘림 -->
				                <div class="card shadow-lg p-3 mb-5 bg-body rounded-5" style="width: 18.9rem; border-radius: 100px;">
				                    <div style="display: flex; justify-content: center;">
				                        <img src="<c:url value='/resources/img/ProfilePicture/${mentorProfile.profileImage}'/>" class="card-img-top" alt="..." style="width: 13.9vw; height: 13.9wh; border-radius: 20px;">
				                    </div>
				                    <div class="card-body">
				                        <h5 class="card-title">${mentorProfile.nickname}</h5>
				                        <p class="card-text">${fn:substring(mentorProfile.introduction, 0, 50)}...</p>
				                        <a href="<c:url value='/mentorprofilepage?nickname=${mentorProfile.nickname}'/>" class="btn btn-primary">상세보기</a>
				                    </div>
				                </div>
				            </div>
				        </c:forEach>
				    </div>
				</div>
				<div class="row">
					<div class="d-flex flex-row justify-content-center">
			        	<c:forEach var="pagenumbers3" items="${pagenumbers3}" varStatus="status"> 
			        		<div class="mx-2">             
			            	<a  href="<c:url value='/Search?page=${pagenumbers3}&search=${search}'/>">${pagenumbers3}</a>
			            	</div>
			        	</c:forEach>
			    	</div>
				</div>  	  	
			</div>	
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>