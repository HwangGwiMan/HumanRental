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
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">게시판</h1>
		</div>
	</div>

	<div class="container">

		<form:form modelAttribute="board" action="./boardupdate?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal" method="POST">
			<input name="id" type="hidden" class="form-control" value="${member.memberId}">
			<input name="boardId" type="hidden" class="form-control" value="${board.boardId}">			
			<div class="form-group row">
				<label class="col-sm-2 control-label" >닉네임</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" value="${board.name}" readonly>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" >제목</label>
				<div class="col-sm-5">
					<input name="title" type="text" class="form-control" value="${board.title}">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label" >내용</label>
				<div class="col-sm-8">
					<textarea name="content" cols="50" rows="5" class="form-control">${board.content}</textarea>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
				 <input type="submit" class="btn btn-primary " value="수정">				
					 <input type="reset" class="btn btn-danger " value="취소 ">
				</div>
			</div>
		</form:form>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>



