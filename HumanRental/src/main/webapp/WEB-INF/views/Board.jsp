<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String sessionId = (String) session.getAttribute("user");
%>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<script type="text/javascript">
	function checkForm() {	
		var sessionId = <%= sessionId %>;
		if (sessionId == null || sessionId.isEmpty()) {
			alert("로그인 해주세요.");
			return false;
		}
		// URL에서 해시 태그 제거
		location.href = "./boardwrite".split("#")[0];
		// 이벤트의 기본 동작 중지
		event.preventDefault();
		// false를 반환하여 이벤트 전파 중지
		return false;
	}
</script>
<title>Board</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="row align-items-end pt-5">
			<a href="<c:url value="/board"/>" class="text-decoration-none fw-bold fs-1 col-3 text-center text-dark">자유 게시판</a>
			<a href="<c:url value="/board2"/>" class="text-decoration-none fs-5 col-2 text-left text-dark">공지사항</a>
		</div>
		<hr>
	</div>
	<div class="container">
		<form:form modelAttribute="BoardSearch" action="./board?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
			<div>
				<div class="text-end">
					<span class="badge text-bg-dark">전체 ${total_record}건</span>
				</div>
			</div>
			<div>
				<table class="table table-hover">
					<tr>
						<th class="col-1">번호</th>
						<th class="col-6">제목</th>
						<th class="col-2">작성일</th>
						<th class="col-1">조회</th>
						<th class="col-2">글쓴이</th>
					</tr>
					<c:forEach items="${boardlist}" var="board" varStatus="status">
                    <tr>
                        <td>${fn:length(boardlist) - status.index}</td>
                        <td><a href="./boardview?boardId=${board.getBoardId()}&pageNum=${pageNum}">${board.getTitle()}</a></td>
                        <td>${board.getRegist_day()}</td>
                        <td>${board.getHit()}</td>
                        <td>${board.getName()}</td>
                    </tr>
                    </c:forEach>
				</table>
			</div>
			<div align="center">
				<c:set var="pageNum" value="${pageNum}" />
				<c:forEach var="i" begin="1" end="${total_page}">
					<a href="<c:url value="./board?pageNum=${i}"/>" class="text-decoration-none">
						<c:choose>
							<c:when test="${pageNum==i}">
								<font color='4C5317'><b> [${i}]</b></font>
							</c:when>
							<c:otherwise>
								<font color='4C5317'> [${i}]</font>
							</c:otherwise>
						</c:choose>
					</a>
				</c:forEach>
			</div>
			<div align="left">
				<table>
					<tr>
						<td width="100%" align="left">&nbsp;&nbsp; 
						<select name="items" class="txt">
								<option value="title">제목에서</option>
								<option value="content">본문에서</option>
								<option value="name">글쓴이에서</option>
						</select> 
						<input name="text" type="text" /> 
						<input type="submit" id="btnAdd" class="btn btn-dark text-center" value="검색" />
						</td>
						<td width="100%" align="right">
							<% if(sessionId==null){ %>
							<a href="#" onclick="checkForm(); return false;" class="btn btn-dark text-nowrap">&laquo;글쓰기</a>
							<%}else{%>
							<a href="<c:url value="/boardwrite"/>" class="btn btn-dark text-nowrap">&laquo;글쓰기</a>
							<%}%>
						</td>
					</tr>
				</table>
			</div>
		</form:form>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
