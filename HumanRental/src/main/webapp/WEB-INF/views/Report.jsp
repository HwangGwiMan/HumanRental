<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>신고</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		
		<!-- jquery -->	
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		
		<script src="<c:url value="/resources/js/report.js"/>"></script>
	</head>
	<body>
		<form class="container" action="<c:url value="/boardreport" />" method="post" name="reportForm">
			<div class="row p-3 justify-content-center">신고하기</div>
			<div class="row p-3">
				<div>신고 유형 : <input type="text" name="target" value="${ target }" disabled> </div>
			</div>
			<div class="row p-3">
				<div>신고 대상</div>
				<div class="row">
					<div class="col-4 p-2">유저 ID :</div>
					<div class="col"><input type="text" name="memberId" value="${ memberId }" disabled></div>
				</div>
				<div class="row">
					<div class="col-4 p-2">대상 ID :</div>
					<div class="col">
						<c:choose>
							<c:when test="${ target == '게시글' }">
								<input type="text" name="boardId" value="${ boardId }" disabled> 
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="row p-3">
				<div>신고 내용</div>
				<select name="type">
					<option value="IllegalInformation">불법 정보</option>
					<option value="UnpleasantExpression">불쾌한 표현 사용</option>
					<option value="CopyrightViolation">저작권 위반</option>
					<option value="Pornography">음란물</option>
				</select>
			</div>
			<div>
				<div class="btn" onclick="javascript:reportSubmit()">확인</div>
				<button class="btn" onclick="window.close()">취소</button>
			</div>
		</form>
	</body>
</html>