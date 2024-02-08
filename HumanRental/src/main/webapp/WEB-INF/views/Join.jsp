<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Document</title>
	    
	    <!-- css -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	    <script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_nav.css"/>"> 
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_section1.css"/>">
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_section2.css"/>">
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_section3.css"/>">
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_footer.css"/>">
	    
	    <!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	    
	    <!-- js -->
	    <script src="<c:url value="/resources/js/join.js" />"></script>
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
	    <c:if test="${ error != null }">
	    	<p>${ error }
	    </c:if>
	    <form:form modelAttribute="member" method="post" id="joinForm">
	    	아이디 : <form:input path="memberId" name="username" id="memberId" required="true"/> <a onclick="javascript:idDuplicateCheck()">중복 확인</a>
	    	비밀번호 : <form:input path="memberPw" name="password" id="memberPw" required="true"/>
	    	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	    	<a onclick="javascript:formSubmit()">제출</a>
	    </form:form>
	    
	</body>
</html>