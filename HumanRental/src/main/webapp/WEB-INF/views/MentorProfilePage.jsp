<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
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
      <section class="pt-5 pb-0">
        <div class="container">
            <div class="row g-0 g-lg-5">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card shadow p-2 mb-4 text-center">
                                <div class="rounded-3" style="margin-top:10px;">
    								<div><h3>${member.getNickName()}님</h3></div>
                                    <div style="padding:10px;"></div>
                                    <div class="">
										<img src='<c:url value="/resources/img/ProfilePicture/${member.getProfileImage()}"/>' width="240" height="179.00237529691" style="cursor:hand;border-radius:10px;" class="zz_image"/>
                                    </div>                                    
                                </div>
                                <br><br>
                            </div>
                            <!-- Instructor image END -->
                        </div>
                        <div class="col-lg-8">
                            <div class="card card-body shadow p-4 mb-4">
                                <!-- Education START -->
                                <!-- Title -->
                                <div class="alert alert-primary alert-dismissible fade show mt-2 mb-0 rounded-3 p-3 px-3"
                                    role="alert">
                                    <h3>기본정보</h3>
                                </div>
                                <div class="row" style="padding-top:30px;">
                                    <!-- Education item -->
                                    <div class="d-flex align-items-center col-lg-6 mb-4">
                                        <span class="icon-md text-dark mb-0 bg-light rounded-3"><i
                                                class="bi bi-emoji-laughing fs-5 text-primary"></i></span>
                                        <div class="ms-3">
                                            <h6 class="mb-0">닉네임</h6>
                                            <p class="mb-0 small">${member.getNickName()}</p>
                                        </div>
                                    </div>
                                    <!-- Education item -->
                                    <div class="d-flex align-items-center col-lg-6 mb-4">
                                        <span class="icon-md text-dark mb-0 bg-light rounded-3"><i
                                                class="bi bi-building fs-5 text-primary"></i></span>
                                        <div class="ms-3">
                                            <h6 class="mb-0">분야</h6>
                                            <p class="mb-0 small">${mentorprofile.getCategory()}</p>
                                        </div>
                                    </div>
                                    <!-- Education END -->
                                    <!-- Education item -->
                                    <div class="d-flex align-items-center col-lg-6 mb-4">
                                        <span class="icon-md text-dark mb-0 bg-light rounded-3">
                                            <i class="bi bi-gender-female fs-5 text-primary"></i>
                                        </span>
                                        <div class="ms-3">
                                            <h6 class="mb-0">성별</h6>
                                            <p class="mb-0 small">${member.getGender()}</p>
                                        </div>
                                    </div>
                                    <!-- Education item -->
                                    <div class="d-flex align-items-center col-lg-6 mb-4">
                                        <span class="icon-md text-dark mb-0 bg-light rounded-3"><i
                                                class="bi bi-person-badge-fill fs-5 text-primary"></i></span>
                                        <div class="ms-3">
                                            <h6 class="mb-0">나이</h6>
                                            <p class="mb-0 small">${member.getAge()}</p>
                                        </div>
                                    </div>
                                    <div class="d-flex align-items-center col-lg-6 mb-4">
                                        <span class="icon-md text-dark mb-0 bg-light rounded-3"><i
                                                class="bi bi-geo-fill fs-4 text-primary"></i></span>
                                        <div class="ms-3">
                                            <h6 class="mb-0">주소</h6>
                                            <p class="mb-0 small">${member.getAddress()}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>                           
    </section>
    <div class="container">
        <div class="mt-4 border border-2 border-dashed rounded  fw-light" style="background-color:#ffffff !important;padding:20px;">
            <div class="alert alert-primary alert-dismissible fade show mt-2 mb-0 rounded-3 p-3 px-3" role="alert">
                <div>
                    <h4>자격증</h4>
                </div>
            </div>
	        <div style="padding:10px;"></div>
	        <div class="p-2 mb-2">
				${mentorprofile.getCertification()}
	        </div>
	     </div>
	  </div>	   
 	  <div class="container">
      	<div class="mt-4 border border-2 border-dashed rounded  fw-light" style="background-color:#ffffff !important;padding:20px;">
            <div class="alert alert-primary alert-dismissible fade show mt-2 mb-0 rounded-3 p-3 px-3" role="alert">
                <div>
                    <h4>자격증</h4>
                </div>
            </div>
	        <div style="padding:10px;"></div>
	        <div class="p-2 mb-2">
				${mentorprofile.getCertification()}
	        </div>
	     </div>
	  </div>	      
    <div class="container"> 	
        <div class="mt-4 border border-2 border-dashed rounded  fw-light"
            style="background-color:#ffffff !important;padding:20px;">
            <div class="alert alert-primary alert-dismissible fade show mt-2 mb-0 rounded-3 p-3 px-3" role="alert">
                <div>
                    <h4>${member.getNickName()}님의 재능 </h4>
                </div>
            </div>
            <div style="padding:10px;"></div>
			 <div class="p-2 mb-2">
				 <div class="qq1 row">
			   		<c:forEach var="listselling" items="${listselling}" varStatus="status">
						<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12"> <!-- 컬럼 설정 -->
							<div class="mentor">
				                <div class="wrapper border" onclick="menteeCheck(this)" data-selling-id="${listselling.sellingId}" style="height: 18vh;">
									<div class="image-wrapper h-100 d-flex flex-column">
										<div style="margin-top: 2vh;">
											<i class="fa-solid fa-gamepad" aria-hidden="true"></i>
										</div>
										<div class="d-flex flex-column justify-content-evenly" style="height: 100%;">
											<div>
												<h1 class="title">${listselling.title}</h1>
											</div> 
											<div class="d-flex justify-content-between">
												<div class="text-start">
													<p class="description" style="font-size: 1.1em">${listselling.nickname}</p>
													<p class="description" style="color: black;">${listselling.category}</p>
												<%-- 	<p type="hidden" style="color: black;">${selling.content}</p> --%>
												</div>
													<div class="text-end">
											<span>
<!--  												    <i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i><i class="fa-regular fa-star" aria-hidden="true"></i>
 --> 											</span> 
											(0)
	                                            <p class="description" style="color: black; font-size: 2.5vh;"> ${listselling.price}원</p>
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
            </div>
        </div>
    <jsp:include page="footer.jsp" />
</body>
</html>