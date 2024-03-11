<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>휴먼렌탈</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		 <script src="<c:url value="/resources/js/login.js" />"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_myPage.css"/>">
		
		<!-- jquery -->
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		
		<script src="<c:url value="/resources/js/myPage.js?ver=1"/>"></script>
	</head>
	<body class="">
		<jsp:include page="nav.jsp"/>
		<div class="container h-75">
			<div class="row pt-5 align-items-start h-75">
				<div class="col-2 p-3 border border-2 rounded-5">
					<div class="row p-3"><img src="<c:url value="/resources/img/ProfilePicture/${ member.profileImage }" />"></div>
					<div class="row justify-content-center">
					<c:choose>
						<c:when test="${ member.memberId != 'admin' }">
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=myPage"/>" class="btn btn-primary ">마이 페이지</a></div><!-- 기본값 -->
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=userCheck"/>" class="btn btn-primary">회원 정보 수정</a></div>
							<div class="row p-3 justify-content-center">
								<a href="#" class="btn btn-primary" id="profileBtn">프로필 수정</a>
								<div class="text-center" style="display: none;">
									<div class="p-1"><a href="<c:url value="/mentor?mode=mentorProfile"/>" class="btn btn-outline-primary text-nowrap">멘토 프로필 조회</a></div>
									<div class="p-1"><a href="<c:url value="/mentee?mode=menteeProfile"/>" class="btn btn-outline-primary text-nowrap">멘티 프로필 조회</a></div>
								</div>
							</div>
							<div class="row p-3">
								<a href="#" class="btn btn-primary" id="registBtn">등록 목록</a>
								<div class="text-center" style="display: none;">
									<div class="p-1"><a href="<c:url value="/buyingListManagement"/>" class="btn btn-outline-primary">삽니다 목록</a></div>
									<div class="p-1"><a href="<c:url value="/sellingListManagement"/>" class="btn btn-outline-primary">팝니다 목록</a></div>
								</div>
							</div>
							<div class="row p-3">
								<a href="#" class="btn btn-primary" id="resvBtn">예약 목록</a>
								<div class="text-center" style="display: none;">
									<div class="p-1"><a href="<c:url value="/reservationApprovalManagement"/>" class="btn btn-outline-primary">예약 승인</a></div>
									<div class="p-1"><a href="<c:url value="/reservationListManagement"/>" class="btn btn-outline-primary">예약 조회</a></div>
								</div>
							</div>
							<div class="row p-3"><a href="#" class="btn btn-primary">일정 정보</a></div>
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=deletememberform"/>" class="btn btn-primary ">회원 탈퇴</a></div>
						</c:when>
						<c:when test="${ member.memberId eq 'admin' }">
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=myPage"/>" class="btn btn-primary">마이 페이지</a></div><!-- 기본값 -->
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=memberManagement"/>" class="btn btn-primary">회원 관리</a></div>
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=mentorApplyManagement"/>" class="btn btn-primary">멘토 신청 관리</a></div>
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=reservationMonitor"/>" class="btn btn-primary">예약 현황</a></div>
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=report"/>" class="btn btn-primary">신고 관리</a></div>
							<div class="row p-3"><a href="<c:url value="/myInfo?mode=blackListManagement"/>" class="btn btn-primary">블랙리스트 관리</a></div>
						</c:when>
					</c:choose>
					</div>
				</div> 
				<div class="col ms-5 px-5 border border-2 rounded-5">
					<div class="row justify-content-center ">
						<c:choose>
							<c:when test="${ mode == 'myPage' }"><!-- 마이 페이지 -->
								<div class="col-5 p-5">
									<div class="row p-3 m-3 border rounded-4">이름 : ${ member.name }</div>
									<div class="row p-3 m-3 border rounded-4">닉네임 : ${ member.nickName }</div>
									<div class="row p-3 m-3 border rounded-4">나이 : ${ member.age }</div>
									<div class="row p-3 m-3 border rounded-4">성별 : ${ member.gender }</div>
									<div class="row p-3 m-3 border rounded-4">전화번호 : ${ member.phone }</div>
									<div class="row p-3 m-3 border rounded-4">주소 : ${ member.address }</div>
									<div class="row p-3 m-3 border rounded-4">멘토 여부 : ${ isMentor }</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'myPageEdit' }"><!-- 회원 정보 수정 -->
								<form class="col p-5" action="<c:url value="/myPageEdit" />" method="post" encType="multipart/form-data" id="editForm">
									<div class="row">
										<div class="col-1"></div>
										<div class="col-4">
											<div><h3>프로필 이미지 등록</h3></div>
											<div class="row"><img width="300" height="300" src="<c:url value="/resources/img/ProfilePicture/${ member.profileImage }" />" id="imageSample"></div>
											<div class="row"><input type="file" accept=".jpg, .png" id="fileUpload" class="btn" name="Image" onchange="javascript:setThumbnail(event);"/></div>
										</div>
										<div class="col-1"></div>
										<div class="col-5 ">
											<div class="row p-3 flex-nowrap align-items-center">
												<div class="col-4 ">아이디</div>
												<div class="col"><input type="text"  value="${ member.memberId }" name="memberId" id="memberId" required="required"/></div>
												<div class="col-5"><a class="btn btn-secondary DupChkBtn">중복 확인</a></div>
											</div>
											<div class="row p-3 align-items-center">
												<div class="col-4">비밀번호</div>
												<div class="col"><input type="password"  value="${ member.memberPw }" name="memberPw" required="required"/></div>
											</div>
											<div class="row p-3 align-items-center">
												<div class="col-4">이름</div>
												<div class="col"><input type="text"  value="${ member.name }" name="name" required="required"/></div>
											</div>
											<div class="row p-3 flex-nowrap align-items-center">
												<div class="col-4">닉네임</div>
												<div class="col"><input type="text"  value="${ member.nickName }" name="nickName" required="required"/></div>
												<div class="col-5"><a class="btn btn-secondary DupChkBtn">중복 확인</a></div>
											</div>
											<div class="row p-3 align-items-center">
												<div class="col-4">나이</div>
												<div class="col"><input type="text"  value="${ member.age }" name="age" required="required"/></div>
											</div>
											<div class="row p-3 align-items-center">
												<div class="col-4">성별</div>
												<div class="col"><input type="text"  value="${ member.gender }" name="gender" required="required"/></div>
											</div>
											<div class="row p-3 align-items-center">
												<div class="col-4">전화번호</div>
												<div class="col"><input type="text"  value="${ member.phone }" name="phone" required="required"/></div>
											</div>
											<div class="row p-3 align-items-center">
												<div class="col-4">주소</div>
												<div class="col"><input width="100px" type="text"  value="${ member.address }" name="address" required="required"/></div>
											</div>
											<a onclick="javascript:formSubmit()" class="btn btn-outline-primary" id="submitBtn">확인</a>
											<a href="<c:url value="/myInfo?mode=myPage" />" class="btn btn-outline-dark">취소</a>
										</div>
									</div>
								</form>
							</c:when>
							<c:when test="${ mode == 'userCheck' }"><!-- 유저 2차 확인 -->
								<form class="col p-5 text-center" action="<c:url value="/myInfo" />" method="post">
									<div class="row"><h2 class="text-nowrap">아이디 비밀번호 확인</h2></div>
									<div class="row justify-content-center pt-5">
										<div class="col-2 p-3">아이디 :</div> 
										<div class="col-3 p-3"><input type="text"  name="memberId"></div>
									</div> 
									<div class="row justify-content-center pb-5">
										<div class="col-2 p-3">비밀번호 :</div>
										<div class="col-3 p-3"><input type="password"  name="memberPw"></div>
									</div>
									<input onclick="javascript:userCheck()" type="button" value="확인" class="btn btn-outline-primary">
								</form>
							</c:when>
							<c:when test="${ mode == 'deletememberform' }"><!-- 회원 탈퇴 -->
	    						<form class="col p-5 text-center" action="<c:url value="/deleteMember" />" method="post">
	       							<div class="row"><h2>회원 탈퇴</h2></div>
	        						<div class="row justify-content-center pt-5">
	            						<div class="col-2 p-3">아이디 :</div> 
	            						<div class="col-3 p-3"><input type="text" readonly="readonly" value="${member.memberId}" id="memberId" name="memberId"></div>
	        						</div> 
	       							<div class="row justify-content-center pb-5">
	            						<div class="col-2 p-3">비밀번호:</div>
	            						<div class="col-3 p-3"><input type="password" required id="memberPw" name="memberPw"></div>
	        						</div>
									<input onclick="javascript:deletemember22()" type="button" value="확인" class="btn btn-outline-primary">
	    						</form>
	    					</c:when>
	    					<c:when test="${ mode == 'mentorFail' }">
	                           <script type="text/javascript">
	                                  window.onload = function(){
	                                    alert("멘토 등록이 필요합니다.");
	                                    window.location.href = "http://localhost:8080/HumanRental/mentorIntro";
	                                	}
	                            </script>
                     		</c:when>         
							<c:when test="${ mode == 'mentorProfile' }"><!-- 멘토 프로필 -->
								<div class="col p-5">
									<div class="row pb-3"><h3>멘토 프로필 등록</h3></div>
									<form action="<c:url value='/mentorProfileRegister?mode=111'/>" method="post" enctype="multipart/form-data">
										<div class="row pb-3">
											<div class="col-2"><h4>카테고리</h4></div>
		    								<div class="col">
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
	    								</div>
	    								<div class="row pb-3">
	    									<div>
	    										<h4>자기 소개</h4>
	    									</div>
	    									<div>
	        									<input type="text" name="introduction" style="width:400px;height:200px;font-size:20px;"></input>
	        								</div>
	    								</div>
	    								<div class="row pb-3">
	    									<div>
	    										<h4>보유하신 자격증을 입력해주세요.</h4>
	    									</div>
	    									<div>
	    										<input type=text name="certification" style="width:400px;height:100px;font-size:20px;" ></input>
	    									</div>
	    								</div>
	    								<div class="file-uploader-section pb-3">
    										<h4 class="fileuploder">자격증 등록</h4>
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
										<button type="submit" class="btn btn-primary">확인</button>
									</form>
								</div>
							</c:when>
							<c:when test="${ mode == 'mentorInformation' }">
								<div class="col-5">
									<div>
										<h4>멘토 프로필 조회 </h4>
										<br><br>
										<h3>멘토 카테고리</h3>
										<div><p>${mentorprofile.category}</p></div>
										<br><br>
										<h3>멘토 자격증이당 </h3>
										<div>${mentorprofile.certification}</div>
										<br><br>
										<h3>멘토 소개당</h3>
										<div>${mentorprofile.introduction}</div>
									</div>
									<div class="row"><img width="50" height="50" src="<c:url value="/resources/img/ProfilePicture/${ mentorprofile.filename1 }" />" id="imageSample1"></div>
									<div class="row"><img width="50" height="50" src="<c:url value="/resources/img/ProfilePicture/${ mentorprofile.filename2 }" />" id="imageSample2"></div>
									<div class="row"><img width="50" height="50" src="<c:url value="/resources/img/ProfilePicture/${ mentorprofile.filename3 }" />" id="imageSample3"></div>
									<div><a href="<c:url value="/mentorprofileupdate?mode=callupdatementorprofileform"/>">멘토프로필 수정 </a></div>
								</div>		
							</c:when>
							<c:when test="${ mode == 'mentorProfileUpdate' }">
								<div class="col-4">
									<h3>멘토 프로필 업데이트</h3>
									<br><br>
									<form action="<c:url value='/mentorProfileUpdate?mode=updatementorprofile"'/>" method="post" enctype="multipart/form-data">
											<h2>카테고리</h2>
	    								<div  style="display: flex;  justify-content:space-between;">
	        								<label for="checkbox-1">운동</label>
	        								<input type="checkbox" id="checkbox-1" name=category value="운동"
											<c:if test="${mentorprofile.category.trim().toLowerCase().contains('운동')}">checked</c:if>>
											
	        								<label for="checkbox-2">음악</label>
	        								<input type="checkbox" id="checkbox-2" name=category value="음악"
											<c:if test="${mentorprofile.category.trim().toLowerCase().contains('음악')}">checked</c:if>>
											
	        								<label for="checkbox-3">게임</label>
	        								<input type="checkbox" id="checkbox-3" name=category value="게임"
											<c:if test="${mentorprofile.category.trim().toLowerCase().contains('게임')}">checked</c:if>>
											
	        								<label for="checkbox-4">공부</label>
	        								<input type="checkbox" id="checkbox-4" name=category value="공부"
	        								<c:if test="${mentorprofile.category.trim().toLowerCase().contains('공부')}">checked</c:if>>
	        								
	        								<label for="checkbox-5">기타</label>
	        								<input type="checkbox" id="checkbox-5" name=category value="기타"
	        								<c:if test="${mentorprofile.category.trim().toLowerCase().contains('기타')}">checked</c:if>>
	    								</div>
	    								<br><br>
	    								<div>
	    									<div>
	    										<h3>자기 소개</h3>
	    									</div>
	    									<div>
												<input type="text" name="introduction" style="width:400px;height:200px;font-size:20px;" value="${fn:escapeXml(mentorprofile.introduction)}"></input>
	        								</div>
	    								</div>
	    								<br><br>
	    								<div>
	    									<h2>너의 자격증을 적어랑</h2>
	    								</div>
	    								<div>
	    									<input type=text name="certification" style="width:400px;height:100px;font-size:20px;" value="${fn:escapeXml(mentorprofile.introduction)}" ></input>
	    								</div>
	    								<br><br>
	    								<div class="file-uploader-section">
    										<h3 class="fileuploder">자격증 등록</h3>
    										<div class="file-upload-field">
    										 	<a>${fn:escapeXml(mentorprofile.filename1)}</a>
        										<label for="file1">자격증 파일 1:</label>
        										<input type="file" id="file1" name="file1" value="${fn:escapeXml(mentorprofile.filename1)}" multiple>
    										</div>
    										<div class="file-upload-field">
    										    <a>${fn:escapeXml(mentorprofile.filename2)}</a>
        										<label for="file2">자격증 파일 2:</label>
        										<input type="file" id="file2" name="file2" value="${fn:escapeXml(mentorprofile.filename2)}" multiple>
    										</div>
    										<div class="file-upload-field">
    											<a>${fn:escapeXml(mentorprofile.filename3)}</a>
        										<label for="file3">자격증 파일 3:</label>
        										<input type="file" id="file3" name="file3" value="${fn:escapeXml(mentorprofile.filename3)}" multiple>
    										</div>
										</div>
										<button type="submit">확인</button>
									</form>
								</div>
							</c:when>
							<c:when test="${ mode == 'menteeProfileRegister' }">
								<div class="col p-5">
									<div class="row pb-3"><h3>멘티 프로필 등록</h3></div>
									<form  action="<c:url value='/menteeregisterinsert?mode=11'/>" method="post">
										<div class="row pb-3 ">
											<div class="col-2"><h4>카테고리</h4></div>
		    								<div class="col">
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
	    								</div>
	    								<div class="row pb-3">
	    									<div>
	    										<h4>자기 소개</h4>
	    									</div>
	    									<div>
	        									<input name="introduction" style="width:400px;height:200px;font-size:20px;"></input>
	        								</div>
	    								</div>
	    								<button type="submit" class="btn btn-primary">확인</button>
									</form>
								</div>
							</c:when>	
							<c:when test="${ mode == 'menteeInformation'}">
								<div class="col-1"> </div>	
								<br><br>
								<div class="col-5">
									<div class="row p-3">관심분야 :${ mentee.interest} </div>
									<div class="row p-3">소개 :${ mentee.introduction}</div>
									<div><a href="<c:url value="/callmenteeupdateform?mode=menteeProfileUpdate"/>">멘티 프로필 수정</a></div>
								</div>	
							</c:when>
							<c:when test="${ mode == 'menteeProfileUpdate'}">
								<div class="col-1"></div>	
								<br><br>
								<div class="col-5">
									<br><br>
										<form  action="<c:url value="/menteeProfileUpdate?mode=12"/>" method="post">
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
							
							<c:when test="${ mode == 'memberManagement' }"><!-- 멤버 관리 페이지 -->
								<div class="p-5">
									<div class="row p-3 text-center">
										<a href="<c:url value="/myInfo?mode=memberManagement"/>" class="col-1 m-1 btn btn-outline-info">전체</a>
										<a href="<c:url value="/myInfo?mode=memberManagement&t=Accept"/> " class="col-2 m-1  btn btn-primary">멘토 승인</a>
										<a href="<c:url value="/myInfo?mode=memberManagement&t=NotRegist"/>" class="col-2 m-1 btn btn-secondary">멘토 미승인</a>
									</div>
									<div style="overflow-y:scroll; width:auto; height:400px;">
										<table class="table table-hover" >
											<thead>
												<tr id="thead">
													<th>순번</th>
													<th>유저 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>가입일<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>멘토 권한<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>멘토 등록일<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
												</tr>
											</thead>
											<tbody id="tbody">	
											<c:forEach var="member" items="${memberList}" varStatus="status">
												<tr>		
													<td>${ status.count }</td>
													<td>${ member.memberId }</td>
													<td>${ member.memberJoinDate }</td>
													<td>
														<c:if test="${ not empty member.mentorId }">
															<div class="badge bg-primary">승인</div>
														</c:if>
														<c:if test="${ empty member.mentorId }">
															<div class="badge bg-secondary">미승인</div>
														</c:if>
													</td>
													<td>${ member.mentorRegistDate }</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'mentorApplyManagement' }">
								<div class="p-5">
									<div class="row p-3 text-center">
										<a href="<c:url value="/myInfo?mode=mentorApplyManagement"/>" class="col-1 m-1 btn btn-outline-info">전체</a>
										<a href="<c:url value="/myInfo?mode=mentorApplyManagement&t=Confirm"/> " class="col-2 m-1  btn btn-primary">처리된 요청</a>
										<a href="<c:url value="/myInfo?mode=mentorApplyManagement&t=Wait"/>" class="col-2 m-1 btn btn-secondary">보류 중인 요청</a>
									</div>
									<div style="overflow-y:scroll; width:auto; height:400px;">
										<table class="table table-hover "><!-- 멘토 신청 관리 -->
											<thead>
												<tr id="thead">
													<th>순번</th>
													<th>유저 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>신청일<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>처리결과<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>처리일<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
												</tr>
											</thead>
											<tbody id="tbody">
											<c:forEach var="applyInfo" items="${applyList}" varStatus="status">
												<tr onclick="javascript:readApplyInfo('${ applyInfo.memberId }', '${ applyInfo.registId }')">
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
											</tbody>
										</table>
									</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'applyInfo' }">
								<div class="col p-5">
									<div class="row">
										<div class="col m-2">
											<img width="300" height="200" src="<c:url value="/resources/img/ProfilePicture/${ applyInfo.profileImage }" />">
										</div>
										<div class="row p-3">
											<div class="col-2">신청자 ID :</div>
											<div class="col">${ applyInfo.info.memberId }</div>
										</div>
										<div class="row p-3">
											<div class="col-2">특기 분야 :</div>
											<div class="col">${ applyInfo.info.specialty }</div>
										</div>
										<div class="row p-3">
											<div class="col-2">주요 활동 지역 :</div>
											<div class="col">${ applyInfo.info.location }</div>
										</div>
										<div class="row p-3">
											<div class="col-2">신청 이유 :</div>
											<div class="col">${ applyInfo.info.reason }</div>
										</div>
										<div class="row p-3">
											<div>기타 사항</div>
											<div>${ applyInfo.info.etc }</div>
										</div>
									</div>
									<div class="row text-center">
										<c:if test="${applyInfo.state == 'Accept'}">
											<div class="col-2 m-1 alert alert-success text-center" role="alert">승인됨</div>
										</c:if>
										<c:if test="${applyInfo.state == 'Refuse'}">
											<div class="col-2 m-1 alert alert-danger text-center" role="alert">거부됨</div>
										</c:if>
										<c:if test="${applyInfo.state == 'Wait'}">
											<a href="<c:url value="/mentorRegist?mId=${ applyInfo.info.memberId }&rId=${ applyInfo.info.registId }" />" class="col-1 m-1 alert alert-success btn btn-success">승인</a>
											<a href="<c:url value="/mentorApplyRefuse?mId=${ applyInfo.info.memberId }&rId=${ applyInfo.info.registId }" />" class="col-1 m-1 alert alert-danger btn btn-danger">거절</a>
										</c:if>
										<a href="<c:url value="/myInfo?mode=mentorApplyManagement" />" class="col-2 m-1 alert alert-secondary btn btn-secondary">목록</a>
									</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'report' }"><!-- 신고 관리 페이지 -->
								<div class="p-5">
									<div style="overflow-y:scroll; width:auto; height:400px;">									
										<table class="table table-hover">
											<thead>
												<tr id="thead">
													<th>순번</th>
													<th>신고자 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>신고 유형<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>신고 대상 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>신고 내용<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>처리 상태<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>신고 날짜<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
												</tr>
											</thead>
											<tbody id="tbody">
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
														<c:when test="${ report.state == 'Warning' }">
															<td><div class="badge bg-warning">경고 처리</div></td>
														</c:when>
														<c:when test="${ report.state == 'Black' }">
															<td><div class="badge bg-dark">블랙 처리</div></td>
														</c:when>
													</c:choose>
													<td>${ report.createDate }</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'reportInfo' }">
								<div class="p-5">
									<c:choose>
										<c:when test="${ not empty reportInfo.boardId }">
											<div class="row">
												<div class="row p-3">
													<div class="col-3">신고 대상 ID :</div>
													<div class="col">${ reportInfo.boardId }</div>
												</div> 
												<div class="row p-3">
													<div class="col-3">신고 대상 멤버 ID :</div>
													<div class="col">${ reportInfo.memberId }</div>
												</div>
												<div class="row p-3">
													<div class="col-3">게시글 제목 :</div>
													<div class="col">${ reportInfo.title }</div>
												</div>
												<div class="row p-3">
													<div class="col-3">신고 유형 :</div>
													<div class="col">${ reportInfo.type }</div>
												</div>
												<div class="row p-3">
													<div class="col-3">신고 횟수 :</div>
													<div class="col">${ reportInfo.reportCount } 회</div>
												</div>
												<div class="row p-3">
													<a href="<c:url value="/boardview?boardId=${ reportInfo.boardId }" />" class="col-3 m-1 p-1 btn btn-light">해당 게시글로 이동</a>
												</div>
											</div>
											<div class="row">
												<a onclick="javascript:sendWarning('${ reportInfo.memberId }','${ reportInfo.type }', '${ reportInfo.title }', '${ reportInfo.reportId }')" class="col-2 m-1 p-1 btn btn-warning">경고 전송</a>
											</div>
										</c:when>
									</c:choose>
									<div class="row">
										<div onclick="javascript:registBlack('${ reportInfo.memberId }', '${ reportInfo.reportId }')" class="col-2 m-1 p-1 btn btn-dark">블랙리스트 추가</div>
										<a href="<c:url value="/myInfo?mode=report" />" class="col-1 m-1 p-1 btn btn-secondary">목록</a>
									</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'blackListManagement' }"><!-- 블랙리스트 관리 페이지 -->
								<div class="p-5">
									<div style="overflow-y:scroll; width:auto; height:400px;">
										<table class="table table-hover">
											<thead>
												<tr id="thead">
													<th>순번</th>
													<th>블랙리스트 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>멤버 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>등록일<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th></th>
												</tr>
											</thead>
											<tbody id="tbody">
												<c:forEach var="black" items="${ blackList }" varStatus="status">
													<tr class="align-middle">
														<td>${ status.count }</td>
														<td>${ black.blackId }</td>
														<td>${ black.memberId }</td>
														<td>${ black.registDate }</td>
														<td><a href="<c:url value="/removeBlack?id=${ black.blackId }" />" class="btn">해제</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</c:when>
							<c:when test="${ mode == 'buyingListManagement' }"><!-- 삽니다 관리 페이지 -->
								<div><hr><h2>삽니다 등록 목록</h2><hr></div>
								<div>
									<table class="table table-hover">
										<tr>
											<th>번호</th>
											<th>제목</th>
											<th>카테고리</th>
											<th>등록일</th>
										</tr>
										<c:forEach var="buying" items="${buyinglist}" varStatus="status">					
											<tr>		
												<td>${ status.count }</td>
												<td><a href='<c:url value="/buying/detail?buyingId=${buying.buyingId}"/>' class="follow">${ buying.title }</a></td>
												<td>${ buying.category }</td>
												<td>${ buying.regist_day }</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:when>
							<c:when test="${ mode == 'sellingListManagement' }"><!-- 팝니다 관리 페이지 -->
								<div><hr><h2>팝니다 등록 목록</h2><hr></div>
								<div>
									<table class="table table-hover">
										<thead>
											<tr>
												<th>번호</th>
												<th>제목</th>
												<th>카테고리</th>
												<th>등록일</th>
											</tr>
										</thead>
										<c:forEach var="selling" items="${sellinglist}" varStatus="status">					
											<tr>		
												<td>${ status.count }</td>
												<td><a href='<c:url value="/selling/detail?sellingId=${selling.sellingId}"/>' class="follow">${ selling.title }</a></td>
												<td>${ selling.category }</td>
												<td>${ selling.regist_day }</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:when>
							<c:when test="${ mode == 'reservationApprovalManagement' }"><!-- 예약 승인 페이지 -->
								<div><hr><h2>예약 승인</h2><hr></div>
								<div>
									<table class="table table-hover">
										<tr>
											<th>번호</th>
											<th>제목</th>
											<th>구분</th>
											<th>신청자</th>
											<th>신청일</th>
											<th>진행 상황</th>
											<th>정보</th>
										</tr>
										<c:forEach var="reservation" items="${reservationlist}" varStatus="status">					
											<tr>		
												<td>${ status.count }</td>
												<c:choose>
												    <c:when test="${ reservation.boardId.contains('buy') }">
														<td><a href="/HumanRental/buying/detail?buyingId=${reservation.boardId}">${ reservation.title }</a></td>
												        <td>재능구매</td>
														<td>${ reservation.menteeNickname }</td>
												    </c:when>
												    <c:when test="${ reservation.boardId.contains('sell') }">
														<td><a href="/HumanRental/selling/detail?sellingId=${reservation.boardId}">${ reservation.title }</a></td>
												        <td>재능판매</td>
														<td>${ reservation.mentorNickname }</td>
												    </c:when>
												</c:choose>
												<td>${ reservation.regist_day }</td>
												<c:choose>
												    <c:when test="${ reservation.approve == '대기' }">
												        <td>대기</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '승인' }">
												        <td>승인</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '거절' }">
												        <td>거절</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '렌탈완료' }">
												        <td>렌탈완료</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '렌탈실패' }">
												        <td>렌탈실패</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '후기작성' }">
												        <td>후기작성</td>
												    </c:when>
												</c:choose>
												<td><a href="/HumanRental/reservationApprovalInfo?reservationId=${ reservation.reservationId }">상세보기</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:when>
							<c:when test="${ mode == 'reservationApprovalInfo' }"><!-- 예약 승인 상세 페이지 -->
								<div><hr><h2>예약 상세 정보</h2><hr></div>
								<div>
									<c:choose>
									    <c:when test="${ reservation.boardId.contains('buy') }">
											게시글 : <a href="/HumanRental/buying/detail?buyingId=${reservation.boardId}">${ reservation.title }</a><br>
											신청자 : ${reservation.menteeNickname}<br>
									    </c:when>
									    <c:when test="${ reservation.boardId.contains('sell') }">
											게시글 : <a href="/HumanRental/selling/detail?sellingId=${reservation.boardId}">${ reservation.title }</a><br>
											신청자 : ${reservation.mentorNickname}<br>
									    </c:when>
									</c:choose>
									예약일 : ${reservation.reservationdate}<br>
									예약 내용 : ${reservation.reservationcontent}<br>
								</div>
								<div>
									<c:if test="${reservation.approve == '대기'}">
										<a href="/HumanRental/reservationApproval?reservationId=${ reservation.reservationId }&approval=yes">승인</a>
										<a href="/HumanRental/reservationApproval?reservationId=${ reservation.reservationId }&approval=no">거절</a>
									</c:if>
									<c:if test="${reservation.approve == '승인'}">
										<a href="/HumanRental/reservationApproval?reservationId=${ reservation.reservationId }&approval=rentalyes">렌탈완료</a>
										<a href="/HumanRental/reservationApproval?reservationId=${ reservation.reservationId }&approval=rentalno">렌탈실패</a>
									</c:if>
									<a href="/HumanRental/reservationApprovalManagement">목록</a>
								</div>
							</c:when>
							<c:when test="${ mode == 'reservationListManagement' }"><!-- 예약 조회 페이지 -->
								<div><hr><h2>예약 조회</h2><hr></div>
								<div>
									<table class="table table-hover">
										<tr>
											<th>번호</th>
											<th>제목</th>
											<th>구분</th>
											<th>신청자</th>
											<th>신청일</th>
											<th>진행 상황</th>
											<th>정보</th>
										</tr>
										<c:forEach var="reservation" items="${reservationlist}" varStatus="status">					
											<tr>		
												<td>${ status.count }</td>
												<c:choose>
												    <c:when test="${ reservation.boardId.contains('buy') }">
														<td><a href="/HumanRental/buying/detail?buyingId=${reservation.boardId}">${ reservation.title }</a></td>
												        <td>재능구매</td>
														<td>${ reservation.mentorNickname }</td>
												    </c:when>
												    <c:when test="${ reservation.boardId.contains('sell') }">
														<td><a href="/HumanRental/selling/detail?sellingId=${reservation.boardId}">${ reservation.title }</a></td>
												        <td>재능판매</td>
														<td>${ reservation.menteeNickname }</td>
												    </c:when>
												</c:choose>
												<td>${ reservation.regist_day }</td>
												<c:choose>
												    <c:when test="${ reservation.approve == '대기' }">
												        <td>대기</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '승인' }">
												        <td>승인</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '거절' }">
												        <td>거절</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '렌탈완료' }">
												        <td>렌탈완료</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '렌탈실패' }">
												        <td>렌탈실패</td>
												    </c:when>
												    <c:when test="${ reservation.approve == '후기작성' }">
												        <td>후기작성</td>
												    </c:when>
												</c:choose>
												<td><a href="/HumanRental/reservationInfo?reservationId=${ reservation.reservationId }">상세보기</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
								
							</c:when>
							<c:when test="${ mode == 'reservationInfo' }"><!-- 예약 상세 정보 페이지 -->
								<div><hr><h2>예약 상세 정보</h2><hr></div>
								<div>
									예약 신청일 : ${reservation.regist_day}<br>
									<c:choose>
									    <c:when test="${ reservation.boardId.contains('buy') }">
											게시글 : <a href="/HumanRental/buying/detail?buyingId=${reservation.boardId}">${ reservation.title }</a><br>
											멘토 : ${reservation.mentorNickname}<br>
											멘티 : ${reservation.menteeNickname}<br>
									    </c:when>
									    <c:when test="${ reservation.boardId.contains('sell') }">
											게시글 : <a href="/HumanRental/selling/detail?sellingId=${reservation.boardId}">${ reservation.title }</a><br>
											멘토 : ${reservation.menteeNickname}<br>
											멘티 : ${reservation.mentorNickname}<br>
									    </c:when>
									</c:choose>
									예약일 : ${reservation.reservationdate}<br>
									예약 내용 : ${reservation.reservationcontent}<br>
									진행 상황 : ${reservation.approve}<br>
									승인일 : ${reservation.signdate}
								</div>
								<div>
									<c:if test="${reservation.approve == '렌탈완료'}">
										<a reservationId="${reservation.reservationId}" onclick="reviewCheck(this)"> 후기작성</a>
										<a reservationId="${reservation.reservationId}" onclick="reviewCheck2(this)">후기관리</a>
									</c:if>
									<a href="/HumanRental/reservationListManagement">목록</a>
								</div>
							</c:when>
							<c:when test="${ mode == 'ReviewPage' }"><!-- 리뷰 페이지 -->
								<div><hr><h2>후기</h2><hr></div>
								<div>
									<form:form modelAttribute="review" action="${reviewmode == 'update' ? './ReviewUpdate' : './ReviewWrite'}?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
										<c:set var="sessionId" value="${sessionScope.user}" />
										<input name="reservationId" type="hidden" class="form-control" value="${reservation.reservationId}">
										<input name="boardId" type="hidden" class="form-control" value="${reservation.boardId}">
										<input name="memberId" type="hidden" class="form-control" value="${sessionId}">
										<input name="ReviewId" type="hidden" class="form-control" value="${review.getReviewId()}">
										<div class="form-group row">
											<label class="col-sm-2 control-label" >수강 클래스</label>
											<div class="col-sm-3">
												<input name="#" type="text" class="form-control" value="${reservation.title}" readonly>
											</div>
										</div>
										<div class="form-group row">
											<c:if test="${reservation.boardId.contains('buy')}">
												<c:if test="${sessionId eq reservation.memberId}">
													<label class="col-sm-2 control-label" >멘티</label>
													<div class="col-sm-3">
														<input name="#" type="text" class="form-control" value="${reservation.menteeNickname}" readonly>
													</div>
												</c:if>
												<c:if test="${sessionId eq reservation.applicantMemberId}">
													<label class="col-sm-2 control-label" >멘토</label>
													<div class="col-sm-3">
														<input name="#" type="text" class="form-control" value="${reservation.mentorNickname}" readonly>
													</div>
												</c:if>
											</c:if>
											<c:if test="${reservation.boardId.contains('sell')}">
												<c:if test="${sessionId eq reservation.memberId}">
													<label class="col-sm-2 control-label" >멘티</label>
													<div class="col-sm-3">
														<input name="#" type="text" class="form-control" value="${reservation.mentorNickname}" readonly>
													</div>
												</c:if>
												<c:if test="${sessionId eq reservation.applicantMemberId}">
													<label class="col-sm-2 control-label" >멘토</label>
													<div class="col-sm-3">
														<input name="#" type="text" class="form-control" value="${reservation.menteeNickname}" readonly>
													</div>
												</c:if>
											</c:if>
										</div>
										<div class="form-group row">
											<label class="col-sm-2 control-label" >별점</label>
											<div class="col-sm-5">
												<label id="range" class="star-rate">
													<input name="starRate" class="star-range" type="range" min="1" max="5" step="1" 
													value="${reviewmode == 'write' ? '5' : review.starRate}" 
													${reviewmode == 'read' ? 'readonly' : 'required'} 
													${reviewmode == 'read' ? 'onchange="return false;"' : 'onchange="_(this); function _(e){ e.setAttribute(\'value\', e.value); };"'} />
														<div class="stars">
															<span><i data-star-value="1" class="fa fa-star"></i></span>
															<span><i data-star-value="2" class="fa fa-star"></i></span>
															<span><i data-star-value="3" class="fa fa-star"></i></span>
															<span><i data-star-value="4" class="fa fa-star"></i></span>
															<span><i data-star-value="5" class="fa fa-star"></i></span>
														</div>
												</label>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-2 control-label" >제목</label>
											<div class="col-sm-5">
												<input name="title" type="text" class="form-control" 
												${reviewmode == 'read' ? 'readonly' : 'required'} 
												value="${reviewmode == 'write' ? '' : review.title}">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-2 control-label" >내용</label>
											<div class="col-sm-8">
												<textarea name="content" cols="50" rows="5" class="form-control" ${reviewmode == 'read' ? 'readonly' : 'required'}>${review.content}</textarea>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-offset-2 col-sm-10 ">
												<c:if test="${reviewmode == 'write'}">
													<input type="submit" class="btn btn-primary" value="작성">
													<input type="reset" class="btn btn-danger" onclick="goBack()" value="취소">
												</c:if>
												<c:if test="${reviewmode == 'read'}">
													<a href="/HumanRental/ReviewUpdate?reservationId=${reservation.reservationId}" class="btn btn-primary">수정</a>
													<a href="/HumanRental/reservationListManagement" class="btn btn-danger">목록</a>
												</c:if>
												<c:if test="${reviewmode == 'update'}">
													<input type="submit" class="btn btn-primary" value="완료">
													<input type="reset" class="btn btn-danger" onclick="goBack()" value="취소">
												</c:if>
											</div>
										</div>
									</form:form>
								</div>
							</c:when>
							<c:when test="${ mode == 'reservationMonitor' }"><!-- 예약 현황 페이지 -->
								<div class="p-5">
									<div class="row p-3 text-center">
										<a href="<c:url value="/myInfo?mode=reservationMonitor"/>" class="col-1 m-1 btn btn-outline-info">전체</a>
										<a href="<c:url value="/myInfo?mode=reservationMonitor&t=buy"/> " class="col-2 m-1 btn btn-primary text-nowrap">재능구매</a>
										<a href="<c:url value="/myInfo?mode=reservationMonitor&t=sell"/>" class="col-2 m-1 btn btn-secondary text-nowrap">재능판매</a>
									</div>
									<div style="overflow-y:scroll; width:auto; height:400px;">
										<table class="table table-hover">
											<thead>
												<tr id="thead">
													<th>순번</th>
													<th>거래 유형<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>재능명<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>멘토 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>멘티 ID<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>일정<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>상태<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
													<th>예약 매칭 날짜<i class="fa-solid fa-sort"></i><i class="fa-solid fa-sort-up" style="display: none;"></i><i class="fa-solid fa-sort-down" style="display: none;"></i></th>
												</tr>
											</thead>
											<tbody id="tbody">
												<c:forEach var="reservation" items="${ reservationList }" varStatus="status">
													<tr>
														<td>${ status.count }</td>
														
														<c:if test="${ fn:contains(reservation.boardId , 'sellingId') }">
															<td><div class="badge bg-secondary">재능판매</div></td>
														</c:if>
														<c:if test="${ fn:contains(reservation.boardId , 'buyingId') }">
															<td><div class="badge bg-primary">재능구매</div></td>
														</c:if>
														
														<td>${ reservation.title }</td>
														<td>${ reservation.memberId }</td>
														<td>${ reservation.applicantMemberId }</td>
														<td>${ reservation.reservationdate }</td>
														
														<c:if test="${ reservation.approve eq '대기' }">
															<td><div class="badge bg-secondary">${ reservation.approve }</div></td>
														</c:if>
														<c:if test="${ reservation.approve eq '승인' }">
															<td><div class="badge bg-success">${ reservation.approve }</div></td>
														</c:if>
														
														<td>${ reservation.signdate }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
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