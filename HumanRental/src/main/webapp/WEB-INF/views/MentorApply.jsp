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
			<div class="row justify-content-center p-5 fs-1">멘토 신청</div>
			<form method="post" action="<c:url value="/mentorApply/submit"/>" class="p-3 ">
				<div class="row p-3">
					<label class="col-3">
						<div class="text-center border-end" >멘토로서 활동하고자 하는 분야</div>
					</label> 
					<div class="col-sm-1 d-flex">
						<div class="col">운동</div>
						<div class="col"><input type="checkbox"  name="specialty" value="운동"></div>
					</div>  
					<div class="col-sm-1 d-flex">
						<div class="col">음악</div>
						<div class="col"><input type="checkbox"  name="specialty" value="음악"></div>
					</div>
					<div class="col-sm-1 d-flex">
						<div class="col">게임</div>
						<div class="col"><input type="checkbox" name="specialty" value="게임"></div>
					</div>
					<div class="col-sm-1 d-flex">
						<div class="col">공부</div>
						<div class="col"><input type="checkbox" name="specialty" value="공부"></div>
					</div>
					<div class="col-sm-1 d-flex">
						<div class="col">기타</div>
						<div class="col"><input type="checkbox" name="specialty" value="기타"></div>
					</div>
				</div>
				<hr>
				<div class="row p-4">
					<label class="col-2 border-end">
						<div class="text-center">주요 활동지</div>
					</label>
					<div class="col-3 px-5 text-nowrap">
						권역
						<select name="location" id="addressRegion"  required="required"></select>
					</div>
					<div class="col-3 px-5 text-nowrap">
						행정 구역
				    	<select name="location" id="addressDo"  required="required"></select>
				    </div>
				    <div class="col-2 px-5 text-nowrap">
				    	시군구
   						<select name="location" id="addressSiGunGu"  required="required"></select>
   					</div>
				</div>
				<hr>
				<div class="row p-4">
					<label class="col-2">
						<div class="text-center border-end">신청하게 된 이유</div>
					</label>
					<div class="col-2 d-flex">
						<div class="col">여유 시간 활용</div>
						<div class="col-2"><input type="checkbox" name="reason" value="여유 시간 활용"></div>
					</div>
					<div class="col-2 d-flex">
						<div class="col">사회적 교류</div>
						<div class="col-2"><input type="checkbox" name="reason" value="사회적 교류"></div>
					</div>
					<div class="col-3 d-flex">
						<div class="col">재능 기부를 통한 만족감</div>
						<div class="col-2"><input type="checkbox" name="reason" value="재능 기부를 통한 만족감"></div>
					</div>
					<div class="col-2 d-flex">
						<div class="col">자기 발전</div>
						<div class="col-2"><input type="checkbox" name="reason" value="자기 발전"></div>
					</div>
				</div>
				<hr>
				<div class="row p-4">
					<label class="col-2 d-flex align-items-center justify-content-center border-end">기타 사항</label>
					<div class="col">
						<textarea rows="5" cols="100" name="etc"></textarea>
					</div>
				</div>
				<hr>
				<div class="row justify-content-center">
					<div class="col-1">
						<input type="submit" value="신청하기" class="p-2 btn btn-success"/>
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>