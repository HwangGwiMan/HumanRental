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
		<div class="row align-items-end">
			<a href="<c:url value="/board2"/>" class="text-decoration-none fw-bold fs-1 col-3 text-center text-dark">공지사항</a>
			<a href="<c:url value="/board"/>" class="text-decoration-none col-1 text-left text-dark">자유 게시판</a>
		</div>
		<hr>
	</div>

	<c:set var="board" value="${board}" />
	<div class="container" style="margin-top: 50px">
		<div class="form-group row">
			<label class="col-sm-1 control-label">닉네임</label>
			<div class="col-sm-3">
				<input name="name" class="form-control" value="${board.name}" readonly>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-1 control-label">제목</label>
			<div class="col-sm-5">
				<input name="subject" class="form-control" value="${board.title}" readonly>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-1 control-label">내용</label>
			<div class="col-sm-8" style="word-break: break-all;">
				<textarea name="content" class="form-control" cols="50" rows="5" readonly>${board.content}</textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-offset-2 col-sm-10 ">
				<c:set var="sessionId" value="${sessionScope.user}" />
				<c:set var="pageNum" value="${pageNum}" />
				<c:if test="${sessionId eq 'admin'}">
					<p>
						<a href="./boarddelete2?boardId=${board.boardId}&pageNum=${pageNum}" class="btn btn-danger">삭제</a> 
						<a href="./boardupdate2?boardId=${board.boardId}&pageNum=${pageNum}" class="btn btn-success">수정</a>
				</c:if>
				<a href="<c:url value="/board2?page=${pageNum}"/>" class="btn btn-primary">목록</a>
				<div>test = ${board.memberId},${pageNum},${sessionId}</div>
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>

