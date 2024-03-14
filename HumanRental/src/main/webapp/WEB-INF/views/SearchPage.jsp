<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	href="<c:url value="/resources/css/style_mentorlist.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/style_menteelist.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/style_SearchPage.css"/>">
<script src="<c:url value="/resources/js/myPage.js"/>"></script>

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
	</div>	
		<div class="search container">
			<div class="qqml mentor">
				<div class="top">재능 판매</div>
				<hr>
				<div class="row">
					<c:forEach var="selling" items="${selling}" varStatus="status">
						<div class="col-xl-4 col-md-6 col-lg-4">
							<div class="single_department">
								<div class="department_thumb">
									<img src="/HumanRental/resources/image/duke.png" />
								</div>
								<div class="department_content">
									<h4>${selling.title}</h4>
									<p>${selling.content}</p>
									<a onclick="menteeCheck(this)" data-selling-id="${selling.sellingId}" class="learn_more">상세페이지</a>
								</div>	
							</div>
						</div>
					</c:forEach>	
				</div>
			</div>
			<br><br>
			<div class="qqml2 mentee">
				<div class="top">재능 구매</div>
				<hr>
				<div class="row">
					<c:forEach var="buying" items="${buying}" varStatus="status">
						<div class="col-xl-4 col-md-6 col-lg-4">
							<div class="single_department">
								<div class="department_thumb">
									<img src="/HumanRental/resources/image/duke.png" />
								</div>
								<div class="department_content">
									<h4>${buying.title}</h4>
									<p>${buying.content}</p>
									<a onclick="mentorCheck(this)" data-buying-id="${buying.buyingId}" class="learn_more">상세페이지</a>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="pagination">
    					<c:forEach var="i" begin="1" end="${totalPages}">
       			 			<a href="/Search?search=${search}&items=${items}&page=${i}">${i}</a>
    					</c:forEach>
					</div>			
				</div>
			</div>
			<div class="qqml2 mentee">
				<div class="top">멘토</div>
				<hr>
				<c:forEach var="mentorprofileAll" items="${mentorprofileAll}" varStatus="status">
					<section class="post-area section-gap" style="border: solid 1px black; border-radius: 10px;">
						<div class="container">
							<div class="row justify-content-center d-flex">
								<div class="col-lg-12 post-list">
									<div class="single-post d-flex flex-row"style="cursor;" >
										<div class="thumb">
											<img src='<c:url value="/resources/img/ProfilePicture/${member.getProfileImage()}"/>' width="200" height="179.00237529691" style="cursor:hand;border-radius:10px;" class="zz_image"/>								
										</div>
										<div class="details">
											<div class="title d-flex flex-row justify-content-between">
												<div class="titles">
													<h4>${mentorprofileAll.nickname}님</h4>
													<br>
													<h6>분야 :${mentorprofileAll.category} </h6>			
												</div>
											</div>
											<p>
												${fn:substring(mentorprofileAll.introduction, 0, 100)}...
											</p>
										</div>
									</div>
								</div>
							</div>		
						</div>
					</section>	
				</c:forEach>
				</div>
			</div>
	<jsp:include page="footer.jsp" />
</body>
</html>