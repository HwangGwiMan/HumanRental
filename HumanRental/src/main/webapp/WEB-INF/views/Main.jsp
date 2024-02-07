<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/style_nav.css"/>"> 
    <link rel="stylesheet" href="<c:url value="/resources/css/style_section1.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style_section2.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style_section3.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style_footer.css"/>">
</head>
<body>


    <nav class="qqnav container">
        <div class="row d-flex align-items-center justify-content-between">
            <div class="col-5 d-flex align-items-center qq1">
                <h4>휴먼렌탈</h4>
                <ul class="nav">
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/give"/>">재능기부</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">멘티구함</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">멘토구함</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">커뮤니티</a></li>
                </ul>
            </div>
            <div class="col-4">
                <form class="form-inline d-flex" action="#">
                    <input class="form-control mr-2" type="text" placeholder="어떤 멘토를 찾으세요?">
                    <button class="btn btn-primary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
            </div>
            <div class="col-3">
                <ul class="nav justify-content-end">
                    <li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>">로그인</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">찜목록</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">멘토신청</a></li>
                    <li class="nav-item qq2"><a class="nav-link" href="#"><i class="fa-regular fa-bell"></i></a></li>
                </ul>
            </div>
        </div>
    </nav>



    <div class="qqnav2 container">
        <div class="row">
            <div class="info">당신의 재능을 나누세요. + 장황한 말</div>
        </div>
    </div>


    <div class="qqs1 container">
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
                            <div class="top">
                                <i class="fas fa-music"></i>
                            </div>
                            <div class="bot">{category}</div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="box">
                            <div class="top">
                                <i class="fas fa-music"></i>
                            </div>
                            <div class="bot">{category}</div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="box">
                            <div class="top">
                                <i class="fas fa-music"></i>
                            </div>
                            <div class="bot">{category}</div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="box">
                            <div class="top">
                                <i class="fas fa-music"></i>
                            </div>
                            <div class="bot">{category}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <div class="qqs2 container">
        <div class="info">
            <br>인기 멘토<br><br>
        </div>
        <div class="row">
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="<c:url value="/resources/img/duke.png"/>" alt=""> 
                    </div>
                    <div class="align-self-center" style="width: 50%;">
                        <h4>{이름}</h4>
                        <div>{내용}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="이미지/duke.png" alt="">
                    </div>
                    <div class="align-self-center" style="width: 50%;">
                        <h4>{이름}</h4>
                        <div>{내용}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="이미지/duke.png" alt="">
                    </div>
                    <div class="align-self-center" style="width: 50%;">
                        <h4>{이름}</h4>
                        <div>{내용}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="이미지/duke.png" alt="">
                    </div>
                    <div class="align-self-center" style="width: 50%;">
                        <h4>{이름}</h4>
                        <div>{내용}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="이미지/duke.png" alt="">
                    </div>
                    <div class="align-self-center" style="width: 50%;">
                        <h4>{이름}</h4>
                        <div>{내용}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="이미지/duke.png" alt="">
                    </div>
                    <div class="align-self-center" style="width: 50%;">
                        <h4>{이름}</h4>
                        <div>{내용}
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="이미지/duke.png" alt="">
                    </div>
                    <div class="align-self-center" style="width: 50%;">
                        <h4>{이름}</h4>
                        <div>{내용}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <div class="qqs3 container">
        <div class="info">
            <br>
            인기 멘토 후기
            <br><br>
        </div>
        <div class="row">
            <div class="col-4">
                <div class="d-flex justify-content-center qq1">
                    <div class="align-self-center">
                        <div class="classname">{강좌명}</div>
                        <div>{후기 내용}</div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="d-flex justify-content-center qq1">
                    <div class="align-self-center">
                        <div class="classname">{강좌명}</div>
                        <div>{후기 내용}</div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="d-flex justify-content-center qq1">
                    <div class="align-self-center">
                        <div class="classname">{강좌명}</div>
                        <div>{후기 내용}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="foot">
        <div>
            <i class="fas fa-copyright text-light me-2"></i> <span>휴먼렌탈</span>, 세상을 바꾸는 힘.
        </div>
        <div>
            Designed By <span>Jeonghwan Lee</span>
        </div>
    </div>
</body>
</html>