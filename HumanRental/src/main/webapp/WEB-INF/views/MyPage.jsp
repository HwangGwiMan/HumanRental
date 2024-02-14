<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이 페이지</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		 <script src="<c:url value="/resources/js/login.js" />"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_myPage.css"/>">
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container">
			<div class="row pt-5 align-items-center">
				<div class="col-2 pt-5">
					<ul class="navbar-nav row justify-content-center">
						<li class="nav-item"><a href="<c:url value="/myInfo?mode=myPage"/>" class="btn">마이 페이지</a></li><!-- 기본값 -->
						<li class="nav-item"><a href="<c:url value="/myInfo?mode=userCheck"/>" class="btn">회원 정보 수정</a></li>
						<li class="nav-item">프로필 수정
							<ul>
								<li class="dropdown-item"><a href="#" class="btn">멘토 프로필 수정</a></li>
								<li class="dropdown-item"><a href="#" class="btn">멘티 프로필 수정</a></li>
							</ul>
						<li>
						<li>예약 목록
							<ul>
								<li class="nav-item"><a href="#" class="btn">삽니다 예약 목록</a></li>
								<li class="nav-item"><a href="#" class="btn">팝니다 예약 목록</a></li>
							</ul>
						</li>
						<li class="nav-item"><a href="#" class="btn">일정 정보</a></li>
						<li class="nav-item"><a href="<c:url value="/myInfo?mode=delete"/>" class="btn">회원 탈퇴</a></li>
					</ul>
				</div>
				<div class="col">
					<div class="row justify-content-center">
						<c:choose>
							<c:when test="${ mode == 'myPage' }">
								<div class="col-1"></div>
								<div class="col-4">
									<div class="row"><img src="<c:url value="/resources/img/ProfilePicture/${ image }" />"></div>
								</div>
								<div class="col-1"></div>
								<div class="col-5">
									<div class="row p-3"><p>이름 : ${ member.name }</div>
									<div class="row p-3"><p>닉네임 : ${ member.nickName }</div>
									<div class="row p-3"><p>나이 : ${ member.age }</div>
									<div class="row p-3"><p>성별 : ${ member.gender }</div>
									<div class="row p-3"><p>전화번호 : ${ member.phone }</div>
									<div class="row p-3"><p>주소 : ${ member.address }</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'myPageEdit' }">
								<div class="col-1"></div>
								<div class="col-4">
									<div class="row"><img src="<c:url value="/resources/img/ProfilePicture/${ image }" />"></div>
									<div class="row"><input type="file" accept=".jpg, .png" id="fileUpload" class="btn"/></div>
								</div>
								<div class="col-1"></div>
								<div class="col-5">
									<div class="row p-3"><p>이름 : <input type="text"  value="${ member.name }"/></div>
									<div class="row p-3"><p>닉네임 : <input type="text"  value="${ member.nickName }"/></div>
									<div class="row p-3"><p>나이 : <input type="text"  value="${ member.age }"/></div>
									<div class="row p-3"><p>성별 : <input type="text"  value="${ member.gender }"/></div>
									<div class="row p-3"><p>전화번호 : <input type="text"  value="${ member.phone }"/></div>
									<div class="row p-3"><p>주소 : <input type="text"  value="${ member.address }"/></div>
									<a href="<c:url value="/myInfo?mode=userCheck" />" class="btn">확인</a>
								</div>
							</c:when>
							<c:when test="${ mode == 'userCheck' }">
								<form class="col-4" action="<c:url value="/myInfo?mode=myPageEdit" />" method="post">
									<div class="row justify-content-center">아이디 비밀번호 확인</div>
									<div class="row justify-content-center">
										<div class="col-4">아이디 :</div> 
										<div class="col"><input type="text"  name="memberId"></div>
									</div> 
									<div class="row justify-content-center">
										<div class="col-4">비밀번호 :</div>
										<div class="col"><input type="password"  name="memberPw"></div>
									</div>
									<input type="submit" value="확인">
								</form>
							</c:when>
							<c:when test="${ mode == 'delete' }">
	    						<form class="col-4" action="<c:url value="/deleteMember" />" method="post">
	       							 <div class="row justify-content-center">회원 탈퇴 </div>
	        						<div class="row justify-content-center">
	            						<div class="col-4">아이디</div> 
	            						<div class="col"><input type="text" readonly="readonly" value="${member.memberId}" id=userid name="memberId"></div>
	        						</div> 
	       							 <div class="row justify-content-center">
	            						<div class="col-4">비밀번호</div>
	            						<div class="col"><input type="password" required id=userpass name="memberPw"></div>
	        						</div>
	        						<input type="hidden" name="mode" value="delete">
	        						<button type="submit" onclick="deleteMember()">확인</button>
	    						</form>
							</c:when>
						</c:choose>
						
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>