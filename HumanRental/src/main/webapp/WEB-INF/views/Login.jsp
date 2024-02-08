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
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	    <script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
	
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_nav.css"/>"> 
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_section1.css"/>">
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_section2.css"/>">
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_section3.css"/>">
	    <link rel="stylesheet" href="<c:url value="/resources/css/style_footer.css"/>">
	</head>
	<body>
	    <jsp:include page="nav.jsp" />
	    <c:if test="${ error != null }">
	    	<p>${ error }
	    </c:if>
	    <form:form modelAttribute="member" method="post">
	    	아이디 : <form:input path="memberId" name="username" />
	    	비밀번호 : <form:input path="memberPw" name="password" />
	    	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	    	<input type="submit">
	    	<a href="#">카카오 로그인</a>
	    	<a href="#">네이버 로그인</a>
	    	<a href="<c:url value="/join" />">회원 가입</a> 
	    </form:form>
	    
	</body>
</html>