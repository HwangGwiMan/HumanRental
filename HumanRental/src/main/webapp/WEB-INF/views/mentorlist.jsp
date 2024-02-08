<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_mentorlist.css"/>">
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="qqml container">
        <div>
            <br>멘토 리스트<br><br><br>
        </div>
        <div class="category">
            <div><i class="fa-solid fa-guitar"></i></div>
            <div><i class="fa-solid fa-person-running"></i></div>
            <div><i class="fa-solid fa-gamepad"></i></div>
            <div><i class="fa-solid fa-comments"></i></div>
            <div><i class="fa-solid fa-truck"></i></div>
            <div><i class="fa-solid fa-hammer"></i></div>
            <div><i class="fa-solid fa-book-open"></i></div>
            <div><i class="fa-solid fa-car"></i></div>
        </div>
        <div class="qq1 row">
            <div class="qq2 col-4">
                <div class="wrapper">
                    <div class="image-wrapper">
                        <img src="/HumanRental/resources/image/duke.png"/>
                        <h1 class="name">이름</h1>
                        <p class="description">프로그래밍 | 뭐시기 | 저시기</p>
                        <br>
                        <p class="information">경력 78년의 개씹풀스택 개발자 <br> 시키면 다 합니다</p>
                        <br>
                        <a href="#" target="_blank" class="follow">신청하기</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="footer.jsp" />
</body>
</html>