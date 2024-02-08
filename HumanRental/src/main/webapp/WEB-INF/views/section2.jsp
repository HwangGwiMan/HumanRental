<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_section2.css"/>">
</head>

<body>
	<div class="qqs1 container">
        <div class="qqs2 container">
        <div class="info">
            <br>인기 멘토<br><br>
        </div>
        <div class="row">
            <div class="col-3">
                <div class="d-flex justify-content-center qq1">
                    <div style="width: 50%;">
                        <img src="/HumanRental/resources/image/duke.png" alt="">
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
</body>
</html>