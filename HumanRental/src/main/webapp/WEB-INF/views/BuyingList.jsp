<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/style_menteelist.css"/>">
	<script src="<c:url value="/resources/js/myPage.js"/>"></script>
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="qqml2 container">
        <div class="text-center fs-1 p-3">
            <div class="p-3">멘토 모집</div>
        </div>
        <div class="category pt-3">
            <div><a href="<c:url value="/BuyingList?category=music"/>"><i class="fa-solid fa-guitar"></i></a></div>
            <div><a href="<c:url value="/BuyingList?category=sports"/>"><i class="fa-solid fa-person-running"></i></a></div>
            <div><a href="<c:url value="/BuyingList?category=game"/>"><i class="fa-solid fa-gamepad"></i></a></div>
            <div><i class="fa-solid fa-comments"></i></div>
            <div><i class="fa-solid fa-car"></i></div>
            <div><i class="fa-solid fa-book-open"></i></div>
            <div><a href="<c:url value="/BuyingList"/>"><h4>전체</h4></a></div>
<%--             <div><a href="<c:url value="/buying" />"><h4>쓰기</h4></a></div> --%>
            <div><a onclick="menteeCheck2()"><h4>쓰기</h4></a></div>
            
        </div>
        <div class="qq1 row">
	        <c:forEach items="${buyinglist}" var="buying">
	            <div class="qq2 col-3">
	                <div class="wrapper">
	                    <div class="image-wrapper">
	                    	<c:choose>
	                    	<c:when test="${buying.category eq 'music'}">
	                        	<i class="fa-solid fa-guitar"></i>
	                        </c:when>
	                        <c:when test="${buying.category eq 'sports'}">
	                        	<i class="fa-solid fa-person-running"></i>
	                        </c:when>
	                        <c:when test="${buying.category eq 'game'}">
	                        	<i class="fa-solid fa-gamepad"></i>
	                        </c:when>
	                        </c:choose>
	                        <h1 class="name">${buying.title}</h1>
							<p class="description">${buying.nickname}</p>
	                        <br>
<%-- 	                        <a href='<c:url value="/buying/detail?buyingId=${buying.buyingId}"/>' class="follow">신청하기</a> --%>
	                        <a onclick="mentorCheck(this)" data-buying-id="${buying.buyingId}" class="follow">신청하기</a>
	                    </div>
	                </div>
	            </div>
	         </c:forEach>
        </div>
    </div>
	<jsp:include page="footer.jsp" />
</body>
</html>