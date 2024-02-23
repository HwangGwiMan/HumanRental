<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
					
					<c:choose>
						<c:when test="${ member.memberId != 'admin' }">
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=myPage"/>" class="btn">마이 페이지</a></li><!-- 기본값 -->
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=userCheck"/>" class="btn">회원 정보 수정</a></li>
							<li class="nav-item">프로필 수정
								<ul>

									<li class="dropdown-item"><a href="<c:url value="/mentor?mode=mentorProfile"/>" class="btn">멘토 프로필 조회</a></li>
									<li class="dropdown-item"><a href="<c:url value="/mentee?mode=menteeProfileRead"/>" class="btn">멘티 프로필 조회</a></li>
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
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=report"/>" class="btn">신고 관리</a></li>
							<li class="nav-item"><a href="<c:url value="/myInfo?mode=blackListManagement"/>" class="btn">블랙리스트 관리</a></li>
						</c:when>
					</c:choose>
					</ul>
				</div>
				<div class="col">
					<div class="row justify-content-center">
						<c:choose>
							<c:when test="${ mode == 'myPage' }"><!-- 마이 페이지 -->
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
							<c:when test="${ mode == 'myPageEdit' }"><!-- 회원 정보 수정 -->
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
							<c:when test="${ mode == 'userCheck' }"><!-- 유저 2차 확인 -->
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
							<c:when test="${ mode == 'delete' }"><!-- 회원 탈퇴 -->
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
	        						<button type="button" onclick="javascript:deleteMember()">확인</button>
	    						</form>
	    					</c:when>
							<c:when test="${ mode == 'mentorProfile' }"><!-- 멘토 프로필 -->
								<div class="col-4">
									<h3>멘토 프로필 등록</h3>
									<br><br>
									<form action="<c:url value='/mentorProfileRegister'/>" method="post" enctype="multipart/form-data">
											<h2>카테고리</h2>
	    								<div  style="display: flex;  justify-content:space-between;">
	        								<label for="checkbox-1">운동</label>
	        								<input type="checkbox" id="checkbox-1" name=category value="운동">
	
	        								<label for="checkbox-2">음악</label>
	        								<input type="checkbox" id="checkbox-2" name=category value="음악">
	
	        								<label for="checkbox-3">게임</label>
	        								<input type="checkbox" id="checkbox-3" name=category value="게임">
	
	        								<label for="checkbox-4">공부</label>
	        								<input type="checkbox" id="checkbox-4" name=category value="공부">
	        								
	        								<label for="checkbox-5">기타</label>
	        								<input type="checkbox" id="checkbox-5" name=category value="기타">
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
	    								<div class="file-uploader-section">
    										<h3 class="fileuploder">자격증 등록</h3>
    										<div class="file-upload-field">
        										<label for="file1">자격증 파일 1:</label>
        										<input type="file" id="file1" name="file1" multiple>
    										</div>
    										<div class="file-upload-field">
        										<label for="file2">자격증 파일 2:</label>
        										<input type="file" id="file2" name="file2" multiple>
    										</div>
    										<div class="file-upload-field">
        										<label for="file3">자격증 파일 3:</label>
        										<input type="file" id="file3" name="file3" multiple>
    										</div>
										</div>
										<button type="submit">확인</button>
									</form>
								</div>
							</c:when>
							<c:when test="${ mode == 'mentorInformation' }">
									<br><br>
									<center>
									<div class="col-5">
										<h3>멘토 프로필 정보 조회 </h3>
										<br><br>
										<br><br>
										<h3>멘토 카테고리</h3>
										<div>${mentorprofile.category}</div>
										<br><br>
										<h3>멘토 자격증이당 </h3>
										<div>${mentorprofile.certification}</div>
										<br><br>
										<h3>멘토 소개당</h3>
										<div>${mentorprofile.introduction}</div>
									</div>
									
									</center>
									<div><a>ㅇㅇㅇ</a></div>
							</c:when>
							<c:when test="${ mode == 'menteeProfileRead' }">
								<div class="col-1"></div>	
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
							<c:when test="${ mode == 'meteeProfile' }">
								<div class="col-1"></div>
								<div class="col-4">
									<div class="row"><img src="<c:url value="/resources/img/ProfilePicture/${ member.profileImage }" />"></div>
								</div>
								<div class="col-1"></div>
								<div></div>
							</c:when>
							<c:when test="${ mode == 'memberManagement' }"><!-- 멤버 관리 페이지 -->
								<div>
									<table class="table table-hover">
										<tr>
											<th>번호</th>
											<th>유저 ID</th>
											<th>가입일</th>
											<th>멘토 권한</th>
											<th>멘토 등록일</th>
										</tr>
										<c:forEach var="member" items="${memberList}" varStatus="status">					
											<tr>		
												<td>${ status.count }</td>
												<td>${ member.memberId }</td>
												<td>${ member.memberJoinDate }</td>
												<td>
													<c:if test="${ not empty member.mentorId }">승인</c:if>
												</td>
												<td>${ member.mentorRegistDate }</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:when>
							<c:when test="${ mode == 'menteeInformation' }">
								<div class="col-1"> </div>	
								<br><br>
								<div class="col-5">
									<div class="row p-3">관심분야 :${ Mentee.interest} </div>
									<div class="row p-3">소개 :${ Mentee.introduction}</div>
									<div><a href="<c:url value="/mentee2?mode=menteeProfileUpdate"/>">멘티 프로필 수정</a></div>
									<div><a href="<c:url value="/mentee3"/>">멘티 프로필 삭제</a></div>
								</div>	
							</c:when>
							<c:when test="${ mode == 'mentorApplyManagement' }">
								<div>
									<div class="row text-center p-3">
										<div class="col-1"><a href="<c:url value="/myInfo?mode=mentorApplyManagement"/>" class="btn btn-outline-info">전체</a></div>
										<div class="col-2"><a href="<c:url value="/myInfo?mode=mentorApplyManagement&t=Confirm"/> " class="btn btn-primary">처리된 요청</a></div>
										<div class="col-2"><a href="<c:url value="/myInfo?mode=mentorApplyManagement&t=Wait"/>" class="btn btn-secondary">보류 중인 요청</a></div>
									</div>
									<table class="table table-hover ">
										<tr>
											<th>번호</th>
											<th>유저 ID</th>
											<th>신청일</th>
											<th>처리결과</th>
											<th>처리일</th>
										</tr>
										<c:forEach var="applyInfo" items="${applyList}" varStatus="status">
											<tr onclick="javascript:readApplyInfo('${ applyInfo.memberId }')">
												<td>${ status.count }</td>
												<td>${ applyInfo.memberId }</td>
												<td>${ applyInfo.applyDate }</td>
												<c:choose>
													<c:when test="${ applyInfo.state == 'Wait' }">
														<td><div class="badge bg-secondary">대기중</div></td>
													</c:when>
													<c:when test="${ applyInfo.state == 'Accept' }">
														<td><div class="badge bg-success">승인</div></td>
													</c:when>
													<c:when test="${ applyInfo.state == 'Refuse' }">
														<td><div class="badge bg-danger">거부</div></td>
													</c:when>
												</c:choose>
												<td>${ applyInfo.confirmDate }</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:when>
							<c:when test="${ mode == 'menteeProfileUpdate'}">
								<div class="col-1"></div>	
								<br><br>
								<div class="col-5">
									<br><br>
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
			    								<div>
			        								<input type ="text" name="introduction" value=${ Mentee.introduction} style="width:400px;height:200px;font-size:20px;"></input>
			    								</div>
			    							</div>
			    							<button type="submit"> 확인</button>
										</form>
								 	</div>		
							</c:when>
							<c:when test="${ mode == 'applyInfo' }">
								<div class="col">
									<div class="row">
										<div class="col">
											<img width="300" height="200" src="<c:url value="/resources/img/ProfilePicture/${ member.profileImage }" />">
										</div>
										<p>신청자 ID : ${ applyInfo.memberId }
										<p>특기 분야 : ${ applyInfo.specialty }
										<p>주요 활동 지역 : ${ applyInfo.location }
										<p>신청 이유 : ${ applyInfo.reason }
										<p>기타 사항
										<p>${ applyInfo.etc }
									</div>
									<div>
										<a href="<c:url value="/mentorRegist?mId=${ applyInfo.memberId }&rId=${ applyInfo.registId }" />" class="btn btn-success">승인</a>
										<a href="<c:url value="/mentorApplyRefuse?mId=${ applyInfo.memberId }&rId=${ applyInfo.registId }" />" class="btn btn-danger">거절</a>
										<a href="<c:url value="/myInfo?mode=mentorApplyManagement" />" class="btn btn-secondary">목록</a>
									</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'report' }"><!-- 신고 관리 페이지 -->
								<div>
									<table class="table table-hover">
										<tr>
											<th>번호</th>
											<th>신고자 ID</th>
											<th>신고 유형</th>
											<th>신고 대상 ID</th>
											<th>신고 내용</th>
											<th>처리 상태</th>
											<th>신고 날짜</th>
										</tr>
										<c:forEach var="report" items="${ reportList }" varStatus="status">
											<tr onclick="javascript:readReportInfo('${ report.reportId }')">
												<td>${ status.count }</td>
												<td>${ report.reporterId }</td>
												<td>${ report.target }</td>
												<td>${ report.targetId }</td>
												<td>${ report.type }</td>
												<c:choose>
													<c:when test="${ report.state == 'Wait' }">
														<td><div class="badge bg-secondary">대기중</div></td>
													</c:when>
													<c:when test="${ report.state == 'Solve' }">
														<td><div class="badge bg-success">처리완료</div></td>
													</c:when>
												</c:choose>
												<td>${ report.createDate }</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:when>
							<c:when test="${ mode == 'reportInfo' }">
								<div class="col">
									<div class="row">
										<p>신청자 ID : 
										<p>특기 분야 : 
										<p>주요 활동 지역 : 
										<p>신청 이유 : 
										<p>기타 사항
										<p>
									</div>
									<div>
										<a href="<c:url value="/" />" class="btn btn-success">처리</a>
										<a href="<c:url value="/" />" class="btn btn-danger">내용</a>
										<a href="<c:url value="/myInfo?mode=report" />" class="btn btn-secondary">목록</a>
									</div>
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