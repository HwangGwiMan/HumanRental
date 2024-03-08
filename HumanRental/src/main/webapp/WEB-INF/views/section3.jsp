<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<%-- <link rel="stylesheet" href="<c:url value="/resources/css/style_section3.css"/>">
 --%>
 </head>

<body>
	<div class="qqs3 container">
        <div class="info text-center fs-1 p-5">
            <div class="p-5">인기 후기</div>
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
        </div>
    </div>
</body>
</html>