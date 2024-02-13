<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_section1.css"/>">
</head>

<body>
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
</body>
</html>