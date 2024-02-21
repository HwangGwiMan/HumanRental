<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이 페이지</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		 <script src="<c:url value="/resources/js/login.js" />"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_myPage.css"/>">
		
		<!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		
		<script src="<c:url value="/resources/js/myPage.js"/>"></script>
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
								<li class="dropdown-item"><a href="<c:url value="/mentee?mode=menteeProfileRead"/>"  class="btn">멘티 프로필 조회</a></li>
							</ul>
						<li>
						<li>등록 이력
							<ul>
								<li class="nav-item"><a href="#" class="btn">삽니다 이력</a></li>
								<li class="nav-item"><a href="#" class="btn">팝니다 이력</a></li>
							</ul>
						</li>
						<li class="nav-item"><a href="#" class="btn">일정 정보</a></li>
						<li class="nav-item"><a href="<c:url value="/myInfo?mode=delete"/>" class="btn">회원 탈퇴</a></li>
					
					<c:choose>
						<c:when test="${ member.memberId != 'admin' }">
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=myPage"/>" class="btn">마이 페이지</a></li><!-- 기본값 -->
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=userCheck"/>" class="btn">회원 정보 수정</a></li>
							<li class="nav-item">프로필 수정
								<ul>
									<li class="dropdown-item"><a href="<c:url value="/myInfo?mode=mentorProfileRead"/>" class="btn">멘토 프로필 조회</a></li>
								</ul>
							<li>
							<li>등록 목록
								<ul>
									<li class="nav-item"><a href="#" class="btn">삽니다 목록</a></li>
									<li class="nav-item"><a href="#" class="btn">팝니다 목록</a></li>
								</ul>
							</li>
							<li class="nav-item"><a href="#" class="btn">일정 정보</a></li>
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=delete"/>" class="btn">회원 탈퇴</a></li>
						</c:when>
						<c:when test="${ member.memberId eq 'admin' }">
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=myPage"/>" class="btn">마이 페이지</a></li><!-- 기본값 -->
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=memberManagement"/>" class="btn">회원 관리</a></li>
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=mentorApplyManagement"/>" class="btn">멘토 신청 관리</a></li>
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=reportManagement"/>" class="btn">신고 관리</a></li>
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=blackListManagement"/>" class="btn">블랙리스트 관리</a></li>
						</c:when>
					</c:choose>
					</ul>
				</div>
				<div class="col">
					<div class="row justify-content-center">
						<c:choose>
							<c:when test="${ mode == 'myPage' }">
								<div class="col-1"></div>
								<div class="col-4">
									<div class="row"><img src="<c:url value="/resources/img/ProfilePicture/${ member.profileImage }" />"></div>
								</div>
								<div class="col-1"></div>
								<div class="col-5">
									<div class="row p-3"><p>이름 : ${ member.name }</div>
									<div class="row p-3"><p>닉네임 : ${ member.nickName }</div>
									<div class="row p-3"><p>나이 : ${ member.age }</div>
									<div class="row p-3"><p>성별 : ${ member.gender }</div>
									<div class="row p-3"><p>전화번호 : ${ member.phone }</div>
									<div class="row p-3"><p>주소 : ${ member.address }</div>
									<div class="row p-3"><p>멘토 여부 : ${ isMentor }</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'myPageEdit' }">
								<form class="col" action="<c:url value="/myPageEdit" />" method="post" encType="multipart/form-data">
									<div class="row">
										<div class="col-1"></div>
										<div class="col-4">
											<div class="row"><img width="300" height="300" src="<c:url value="/resources/img/ProfilePicture/${ member.profileImage }" />" id="imageSample"></div>
											<div class="row"><input type="file" accept=".jpg, .png" id="fileUpload" class="btn" name="Image" onchange="javascript:setThumbnail(event);"/></div>
										</div>
										<div class="col-1"></div>
										<div class="col-5">
											<div class="row p-3"><p>아이디 : <input type="text"  value="${ member.memberId }" name="memberId" id="memberId" required="required"/><a onclick="javascript:idDuplicateCheck(${ member.memberId })" class="btn">중복 확인</a></div>
											<div class="row p-3"><p>비밀번호 : <input type="password"  value="${ member.memberPw }" name="memberPw" required="required"/></div>
											<div class="row p-3"><p>이름 : <input type="text"  value="${ member.name }" name="name" required="required"/></div>
											<div class="row p-3"><p>닉네임 : <input type="text"  value="${ member.nickName }" name="nickName" required="required"/></div>
											<div class="row p-3"><p>나이 : <input type="text"  value="${ member.age }" name="age" required="required"/></div>
											<div class="row p-3"><p>성별 : <input type="text"  value="${ member.gender }" name="gender" required="required"/></div>
											<div class="row p-3"><p>전화번호 : <input type="text"  value="${ member.phone }" name="phone" required="required"/></div>
											<div class="row p-3"><p>주소 : <input width="100px" type="text"  value="${ member.address }" name="address" required="required"/></div>
											<input type="submit" class="btn" value="확인" id="submitBtn">
											<a href="<c:url value="/myInfo?mode=myPage" />" class="btn">취소</a>
										</div>
									</div>
								</form>
							</c:when>
							<c:when test="${ mode == 'userCheck' }">
								<form class="col-4" action="<c:url value="/myInfo" />" method="post">
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
							  <% System.out.println("회원탈퇴용 아이디 비번 나와랏!");%> 
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
	        						<button type="button" onclick="deleteMember()">확인</button>
	    						</form>
	    					</c:when>	
							 <c:when test="${ mode == 'mentorProfileRead' }">
								<div class="col-1"> </div>	
								<br><br>
								<div class="col-5">
								<h3>멘토 프로필 등록</h3>
								<br><br>
								<form  action="<c:url value="/mentor"/>" method="post">
										<h2>카테고리</h2>
    								<div  style="display: flex;  justify-content:space-between;">
        								<label for="checkbox-1">운동</label>
        								<input type="checkbox" id="checkbox-1" name=interest value="운동">

        								<label for="checkbox-2">음악</label>
        								<input type="checkbox" id="checkbox-2" name=interest value="음악">

        								<label for="checkbox-3">게임</label>
        								<input type="checkbox" id="checkbox-3" name=interest value="게임">

        								<label for="checkbox-4">공부</label>
        								<input type="checkbox" id="checkbox-4" name=interest value="공부">
        								
        								<label for="checkbox-5">기타</label>
        								<input type="checkbox" id="checkbox-5" name=interest value="기타">
    								</div>
    								<br><br>
    								<div>
    									<div>
    										<h3>자기 소개</h3>
    									</div>
    									<div>
        									<input type="text" name="introduction" style="width:400px;height:200px;font-size:20px;"></input>
        								</div>
    								</div>
    								<br><br>
    								<div>
    									<h2>너의 자격증을 적어랑</h2>
    								</div>
    								<div>
    									<input type=text name="certification" style="width:400px;height:100px;font-size:20px;" ></input>
    								</div>
    								<br><br>
    								<div>
	    								<h3 class="fileuploder"> 자격증등록 
	            						<input type="file" id="ex_file" name="filename" multiple>
	        							</h3>
        							</div>
        							<button type="submit">확인</button>
								</form>
								</div>
							</c:when>
							<c:when test="${ mode == 'menteeProfileRead' }">
								<div class="col-1"> </div>	
								<br><br>
								<div class="col-5">
								<h3>멘티 신청 항목</h3>
								<br><br>
								<form  action="<c:url value="/mentee"/>" method="post">
										<h2>카테고리</h2>
    								<div  style="display: flex;  justify-content:space-between;">
        								<label for="checkbox-1">운동</label>
        								<input type="checkbox" id="checkbox-1" name=interest value="운동">

        								<label for="checkbox-2">음악</label>
        								<input type="checkbox" id="checkbox-2" name=interest value="음악">

        								<label for="checkbox-3">게임</label>
        								<input type="checkbox" id="checkbox-3" name=interest value="게임">

        								<label for="checkbox-4">공부</label>
        								<input type="checkbox" id="checkbox-4" name=interest value="공부">
        								
        								<label for="checkbox-5">기타</label>
        								<input type="checkbox" id="checkbox-5" name=interest value="기타">
    								</div>
    								<br><br>
    								<div>
    									<div>
    										<h3>자기 소개</h3>
    									</div>
        								<input name="introduction" style="width:400px;height:200px;font-size:20px;"></input>
    								</div>
    								<button type="submit">확인</button>
								</form>
								</div>
							</c:when>
							<c:when test="${ mode == 'menteeInformation' }">
								<div class="col-1"> </div>	
								<br><br>
								<div class="col-5">
									<div class="row p-3">관심분야 :${ Mentee.interest} </div>
									<div class="row p-3">소개 :${ Mentee.introduction}</div>
									<div><a href="<c:url value="/mentee2?mode=menteeProfileUpdate"/>">멘티 프로필 수정</a></li></div>
									<div><a href="<c:url value="/mentee3"/>">멘티 프로필 삭제</a></li></div>
								</div>
							</c:when>
							<c:when test="${ mode == 'menteeProfileUpdate'}">
								<div class="col-1"> </div>	
								<br><br>
								<div class="col-5">
								<form  action="<c:url value="/menteeProfileUpdate"/>" method="post">
										<h2>카테고리</h2>
    								<div  style="display: flex;  justify-content:space-between;">
        								<label for="checkbox-1">운동</label>
        								<input type="checkbox" id="checkbox-1" name=interest value="운동"
        								<c:if test="${Mentee.interest.trim().toLowerCase().contains('운동')}">checked</c:if>>
        									
        								<label for="checkbox-2">음악</label>
        								<input type="checkbox" id="checkbox-2" name=interest value="음악"
        								<c:if test="${Mentee.interest.trim().toLowerCase().contains('음악')}">checked</c:if>>
        								
        								<label for="checkbox-3">게임</label>
        								<input type="checkbox" id="checkbox-3" name=interest value="게임"
        								<c:if test="${Mentee.interest.trim().toLowerCase().contains('게임')}">checked</c:if>>
        									
        								<label for="checkbox-4">공부</label>
        								<input type="checkbox" id="checkbox-4" name=interest value="공부"
        								<c:if test="${Mentee.interest.trim().toLowerCase().contains('공부')}">checked</c:if>>
        								
        								<label for="checkbox-5">기타</label>
        								<input type="checkbox" id="checkbox-5" name=interest value="기타"
        								<c:if test="${Mentee.interest.trim().toLowerCase().contains('기타')}">checked</c:if>>
        								
    								</div>
    								<br><br>
    								<div>
    									<div>
    										<h3>자기 소개</h3>
    									</div>
        								<input type ="text" name="introduction" value=${ Mentee.introduction} style="width:400px;height:200px;font-size:20px;"></input>
    								</div>
    								<button type="submit">확인</button>
								</form>
								</div>
							</c:when>							
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>