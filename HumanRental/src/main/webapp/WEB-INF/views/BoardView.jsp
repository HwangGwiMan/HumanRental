<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<title>Board</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<hr>
		<h1 class="p-3">게시판</h1>
		<hr>
	</div>

	<c:set var="board" value="${board}" />
	<div class="container">
		<div class="form-group row">
			<label class="col-sm-2 control-label">성명</label>
			<div class="col-sm-3">
				<input name="name" class="form-control" value="${board.getName()}">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label">제목</label>
			<div class="col-sm-5">
				<input name="subject" class="form-control" value="${board.title}">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label">내용</label>
			<div class="col-sm-8" style="word-break: break-all;">
				<textarea name="content" class="form-control" cols="50" rows="5">${board.content}</textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-offset-2 col-sm-10 ">
				<c:if test="${sessionId==memberId}">
					<p><a href="./BoardDeleteAction.do?num=${BoardId}%>&pageNum=${nowpage}" class="btn btn-danger">삭제</a> 
						<input type="submit" class="btn btn-success" value="수정">
				</c:if>
				<a href="<c:url value="/board?page=${nowpage}"/>" class="btn btn-primary">목록</a>
				<div>${sessionId.toString()},${board.getMemberId()}</div>
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>


