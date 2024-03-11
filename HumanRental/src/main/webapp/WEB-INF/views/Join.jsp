<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>로그인 페이지</title>
	    
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
	    <jsp:include page="nav.jsp" />
   	    <div class="container vh-100 justify-content-center text-center d-flex flex-column align-items-center">
			<div class="row">
			    <form:form modelAttribute="member" method="post" id="joinForm" class="row justify-content-center" >
   			    	<div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">아이디</div>
			    		<div class="col-3 p-2"><form:input path="memberId" name="username" id="memberId" class="form-control"/></div>
			    		<div class="col-1 p-1 align-self-center"><a class="btn DupChkBtn">중복 확인</a></div>
		    		</div>
	 			    <div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">비밀번호</div>
			    		<div class="col-4 p-2"><form:input path="memberPw" name="password" id="memberPw" class="form-control"/></div>
			    	</div>
			    	<div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">이름</div>
			    		<div class="col-4 p-2"><form:input path="name" class="form-control"/></div>
			    	</div>
					<div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">닉네임</div>
			    		<div class="col-3 p-2"><form:input path="nickName" class="form-control"/></div>
			    		<div class="col-1 p-1 align-self-center"><a class="btn DupChkBtn">중복 확인</a></div>
			    	</div>
			    	<div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">나이</div>
			    		<div class="col-4 p-2"><form:input path="age" class="form-control"/></div>
			    	</div>
			    	<div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">성별</div>
			    		<div class="col-4 p-2"><form:input path="gender" class="form-control"/></div>
			    	</div>
			    	<div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">전화번호</div>
			    		<div class="col-4 p-2"><form:input path="phone" class="form-control"/></div>
			    	</div>
			    	<div class="row justify-content-center">
			    		<div class="col-1 p-2 align-self-center">주소</div>
			    		<div class="col-4 p-2"><form:input path="address" class="form-control"/></div>
			    	</div>
					<div class="col">
				    	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
				    	<a onclick="javascript:formSubmit()" class="btn">제출</a>
			    	</div>
			    </form:form>
		    </div>
	    </div>
	</body>
</html>