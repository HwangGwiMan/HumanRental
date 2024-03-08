<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>

<body>
    <jsp:include page="nav.jsp" />
      <section class="pt-5 pb-0">
        <div class="container">
            <div class="row g-0 g-lg-5">
                <!-- Left sidebar START -->
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-4">
                            <!-- Instructor image START -->
                            <div class="card shadow p-2 mb-4 text-center">
                                <div class="rounded-3" style="margin-top:10px;">
    								<div><h3>닉네임:${member.getNickName()}</h3></div>
                                    <div style="padding:10px;"></div>
                                    <div class=""><a href="#" class="chaos-modal-link"><img
                                                src="/storage/profileImage/profile_ojaki486.png" width="240"
                                                height="179.00237529691" style="cursor:hand;border-radius:10px;"
                                                class="zz_image"></a></div>
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
                                    <!-- Education END -->
                                    <!-- Education item -->
                                    <div class="d-flex align-items-center col-lg-6 mb-4">
                                        <span class="icon-md text-dark mb-0 bg-light rounded-3"><i
                                                class="bi bi-mortarboard-fill fs-5 text-primary"></i></span>
                                        <div class="ms-3">
                                            <h6 class="mb-0">자격증</h6>
                                            <p class="mb-0 small"></p>
                                        </div>
                                    </div>
                                    <!-- Education END -->
                                    <!-- Education item -->
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
        <!-- Title -->
        <div class="mt-4 border border-2 border-dashed rounded  fw-light"
            style="background-color:#ffffff !important;padding:20px;">
            <div class="alert alert-primary alert-dismissible fade show mt-2 mb-0 rounded-3 p-3 px-3" role="alert">
                <div>
                    <h4>소개글</h4>
                </div>
            </div>
            <div style="padding:10px;"></div>
            <div class="p-2 mb-2">
					${mentorprofile.getIntroduction()}
            </div>
        </div>
    </div>
    <div class="container">
        <!-- Title -->
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

			     </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>

</html>