<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<%-- <link rel="stylesheet" href="<c:url value="/resources/css/style_section2.css"/>">
 --%>
<script src="<c:url value="/resources/js/main.js"/>"></script>

</head>

<body>
	<div class="qqs1 container">
        <div class="qqs2 row justify-content-center">
	        <div class="info text-center fs-1 p-5">
	            <div class="p-5">인기 멘토</div>
	        </div>
	        <div class="row">
				<c:forEach var="selling" items="${ sellinglist }">
		            <div class="col-4">
		                <div class="d-flex justify-content-center qq1">
		                    <div style="width: 50%;">
		                        <img src="/HumanRental/resources/image/duke.png" alt="">
		                    </div>
		                    <div class="align-self-center" style="width: 50%;">
		                        <h4>${ selling.nickname }</h4>
		                        <div>${ selling.title }</div>
		                    </div>
		                </div>
		            </div>
	            </c:forEach>
	        </div>
    	</div>
    </div>
</body>
</html>