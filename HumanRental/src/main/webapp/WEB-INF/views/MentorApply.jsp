<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멘토 등록</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>

		<!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>

		<script src="<c:url value="/resources/js/MentorApply.js"/>"></script>
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container">
			<form method="post" action="<c:url value="/mentorRegist/submit"/>">
				<div class="row p-4">
					<label class="col-2">특기 분야</label> 
					운동<input type="checkbox" class="col-sm-1" name="specialty" value="운동">  
					음악<input type="checkbox" class="col-sm-1" name="specialty" value="음악">
					게임<input type="checkbox" class="col-sm-1" name="specialty" value="게임">
					공부<input type="checkbox" class="col-sm-1" name="specialty" value="공부">
					기타<input type="checkbox" class="col-sm-1" name="specialty" value="기타">
				</div>
				<div class="row p-4">
					<label class="col-2">주요 활동지</label>
					<select name="location" id="addressRegion" class="col-sm-2"></select>
				    <select name="location" id="addressDo" class="col-sm-2"></select>
   					<select name="location" id="addressSiGunGu" class="col-sm-2"></select>
				</div>
				<div class="row p-4">
					<label class="col-2">신청하게 된 이유</label>
					여유 시간 활용<input type="checkbox" class="col-sm-1">
					사회적 교류<input type="checkbox" class="col-sm-1">
					재능 기부를 통한 만족감<input type="checkbox" class="col-sm-1">
					자기 발전<input type="checkbox" class="col-sm-1">
				</div>
				<div class="row p-4">
					<label class="col-2">기타 사항</label>
					<div class="col">
						<textarea rows="5" cols="100" >
							
						</textarea>
					</div>
				</div>
				<input type="submit" value="Submit" />
			</form>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>