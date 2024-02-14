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
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container">
			<form>
				<div>
					<label>특기 분야</label> 
					<input type="checkbox">운동  
					<input type="checkbox">음악
					<input type="checkbox">게임
					<input type="checkbox">공부
					<input type="checkbox">기타
				</div>
				<div>
					<label>주요 활동지</label>
					<select name="addressRegion" id="addressRegion"></select>
				    <select name="addressDo" id="addressDo"></select>
   					<select name="addressSiGunGu" id="addressSiGunGu"></select>
				</div>
				<div>
					<label>신청하게 된 이유</label>
					<input type="checkbox">여유 시간 활용
					<input type="checkbox">사회적 교류
					<input type="checkbox">재능 기부를 통한 만족감
					<input type="checkbox">자기 발전
				</div>
					<input type="submit" value="Submit" />
			</form>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>