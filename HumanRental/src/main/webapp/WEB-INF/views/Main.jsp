<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>휴먼 렌탈</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_nav.css"/>">
		<link rel="stylesheet" href="<c:url value="/resources/css/Main.css"/>">
	</head>
	<body>
		<jsp:include page="nav.jsp" />


		<jsp:include page="section0.jsp" />
		<jsp:include page="section1.jsp" />
		<jsp:include page="section2.jsp" />
		<jsp:include page="section3.jsp" />
		<jsp:include page="footer.jsp" />
	</body>
</html>