<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>Board</title>
</head>
</script>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<hr>
		<div class="row align-items-end">
			<a href="<c:url value="/board2"/>" class="text-decoration-none fw-bold fs-1 col-3 text-center text-dark">공지사항</a>
			<a href="<c:url value="/board"/>" class="text-decoration-none col-1 text-left text-dark">자유 게시판</a>
		</div>
		<hr>
	</div>

	<div class="container">

		<form:form modelAttribute="board" action="./boardwrite2?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
			<input name="id" type="hidden" class="form-control"
				value="${member.memberId}">
			<div class="form-group row">
				<label class="col-sm-2 control-label" >닉네임</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" value="${member.name}" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">

					<input name="title" type="text" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8">
					<textarea name="content" cols="50" rows="5" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary " value="수정">	
					<input type="reset" class="btn btn-danger" value="취소" onclick="goBack()">
				</div>
			</div>
		</form:form>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
	<script>
    function goBack() {
        // 브라우저의 이전 페이지로 이동
        history.back();
    }
	</script>
</body>
</html>



