<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/style_board.css"/>">
<title>Board</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row align-items-end pt-5">
			<a href="<c:url value="/board2"/>" class="text-decoration-none fw-bold fs-1 col-3 text-center text-dark">공지사항</a>
			<a href="<c:url value="/board"/>" class="text-decoration-none col-1 text-left text-dark">자유 게시판</a>
		</div>
		<hr>
	</div>

	<c:set var="board" value="${board}" />
	<div class="container board" style="margin-top: 50px">
		<div class="container mt-5">
			<div class="row">
				<div class="col-12 mx-auto">
					<div class="post">
						<h2 class="post-title">${board.title}</h2>
						<p class="post-info">작성자: ${board.name} <span style="float: right">작성일: ${board.regist_day} | 조회수: ${board.hit}</span></p>
						<hr>
						<div class="post-content">
							<pre>${board.content}</pre>
						</div>
					</div>
				</div>
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
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>


