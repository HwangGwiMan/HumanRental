<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_menteelist.css"/>">
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<c:choose>
			<c:when test="${type=='view'}">
		       	<form:form modelAttribute="buying" action="/HumanRental/buying?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
		       		<input type="hidden" name="memberId" value="${ member.memberId }">
		       		<input type="hidden" name="nickname" value="${ member.nickName }">
		       		제목 : <input type="text" name="title">
		       		<br>
		       		내용 : <textarea name="content" cols="50" rows="5"></textarea>
		       		<br>
		       		가격 : 시간당 <input type="number" name="price"> 원
		       		<br>
		       		위치 : <input type="text" name="location">
		       		<br>
		       		카테고리 : <select name="category" class="txt">
								<option value="music">음악</option>
								<option value="sports">스포츠</option>
								<option value="game">게임</option>
							</select> 
					<br>
					<input type="submit" value="제출">
		       	</form:form>
	       	</c:when>
			<c:when test="${type=='update'}">
		       	<form:form modelAttribute="buying" action="/HumanRental/buying/update?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
		       		<input type="hidden" name="buyingId" value="${ buying.buyingId }">
		       		제목 : <input type="text" name="title" value="${ buying.title }">
		       		<br>
		       		내용 : <textarea name="content" cols="50" rows="5">${ buying.content }</textarea>
		       		<br>
		       		가격 : 시간당 <input type="number" name="price" value="${ buying.price }"> 원
		       		<br>
		       		위치 : <input type="text" name="location" value="${ buying.location }">
		       		<br>
		       		카테고리 : <select name="category" class="txt">
								  <option value="music" ${buying.category == 'music' ? 'selected' : ''}>음악</option>
								  <option value="sports" ${buying.category == 'sports' ? 'selected' : ''}>스포츠</option>
								  <option value="game" ${buying.category == 'game' ? 'selected' : ''}>게임</option>
								</select>
					<br>
					<input type="submit" value="제출">
		       	</form:form>
	       	</c:when>
       	</c:choose>
    </div>
	<jsp:include page="footer.jsp" />
</body>
</html>