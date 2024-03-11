<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_menteelist.css"/>">
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="container text-center" style="line-height: 38px">
		<c:choose>
			<c:when test="${type=='view'}">
		       	<form:form modelAttribute="selling" action="/HumanRental/selling?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
 		       		<input type="hidden" name="memberId" value="${ member.memberId }">
		       		<input type="hidden" name="nickname" value="${ member.nickName }">
		       		<div class="row p-5 fs-3">재능 판매 등록</div>
		       		<div class="row p-3">
		       			<div class="col-1">제목</div> 
		       			<div class="col-4"><input type="text" name="title" class="form-control" required="required" maxlength=20></div>
		       			<div class="col-3 form-text">제목은 20자 이내로 작성해주십시오.</div>
		       		</div>
		       		<div class="row p-3">
		       			<div class="col-1">내용</div> 
		       			<div class="col"><textarea name="content" cols="50" rows="5" class="form-control form-control-sm" required="required"></textarea></div>
		       		</div>
		       		<div class="row p-3">
		       			<div class="col-1">가격</div> 
		       			<div class="col-3">
		       				<div class="row">
		       					<div class="col">시간당</div>
		       					<div class="col-5"><input type="number" name="price" class="form-control" required="required"></div>
		       					<div class="col">원</div>
		       				</div>
		       			</div>
		       		</div>
		       		<div class="row p-3">
		       			<div class="col-1">위치</div> 
		       			<div class="col-4"><input type="text" name="location" class="form-control"></div>
		       		</div>
		       		<div class="row p-3">
		       			<div class="col-1">카테고리</div>
		       			<div class="col-1"> 
				       		<select name="category" class="txt form-select">
								<option value="music">음악</option>
								<option value="sports">스포츠</option>
								<option value="game">게임</option>
	   						</select>
   						</div> 
					</div>
					<div>
						<input type="submit" value="제출" class="btn btn-success">
					</div>
		       	</form:form>
	       	</c:when>
			<c:when test="${type=='update'}">
		       	<form:form modelAttribute="selling" action="/HumanRental/selling/update?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
		       		<input type="hidden" name="sellingId" value="${ selling.sellingId }">
		       		제목 : <input type="text" name="title" value="${ selling.title }">
		       		<br>
		       		내용 : <textarea name="content" cols="50" rows="5">${ selling.content }</textarea>
		       		<br>
		       		가격 : 시간당 <input type="number" name="price" value="${ selling.price }"> 원
		       		<br>
		       		위치 : <input type="text" name="location" value="${ selling.location }">
		       		<br>
		       		카테고리 : <select name="category" class="txt">
								  <option value="music" ${selling.category == 'music' ? 'selected' : ''}>음악</option>
								  <option value="sports" ${selling.category == 'sports' ? 'selected' : ''}>스포츠</option>
								  <option value="game" ${selling.category == 'game' ? 'selected' : ''}>게임</option>
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