<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<title>휴먼렌탈</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_buyingList.css"/>">
		<script src="<c:url value="/resources/js/myPage.js"/>"></script>
		<script src="<c:url value="/resources/js/buying.js"/>"></script>
	</head>
	
	<body>
		<jsp:include page="nav.jsp" />
		<div class="info">
			<b>열정적인 학습자들을 위한 배움의 장</b>
			<span><b>-재능 구매-</b></span>
		</div>
		<div class="qqml2 container">
			<div class="category col-12 d-flex justify-content-around align-items-center m-auto">
				<div class="bar">
					<a href="<c:url value="/BuyingList?pageNum=1"/>" class="text-decoration-none"><i class="fa-solid fa-a"></i><br><span>ALL</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/BuyingList?category=music"/>"><i class="fa-solid fa-music"></i><br><span>Music</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/BuyingList?category=sports"/>"><i class="fa-solid fa-person-running"></i><br><span>Sprots</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/BuyingList?category=game"/>"><i class="fa-solid fa-gamepad"></i><br><span>Game</span></a>
				</div>
				<div class="bar">
					<a href="<c:url value="/BuyingList?category=study"/>"><i class="fa-solid fa-book-open"></i><br><span>Study</span></a>
				</div>
				<div class="bar"><a onclick="menteeCheck2()" class="text-decoration-none" style="cursor: pointer;"><i class="fa-solid fa-pen-to-square"></i><br><span>Write</span></a></div>
			</div>
			<div class="qq1 row">
		        <c:forEach items="${buyinglist}" var="buying">
		            <div class="qq2 col-3">
		                <div class="wrapper border" onclick="mentorCheck(this)" data-buying-id="${buying.buyingId}">
		                    <div class="image-wrapper h-100 d-flex flex-column">
		                    	<div style="margin-top: 2vh;">
		                    	<c:choose>
		                    	<c:when test="${buying.category eq 'music'}">
		                        	<i class="fa-solid fa-music"></i>
		                        </c:when>
		                        <c:when test="${buying.category eq 'sports'}">
		                        	<i class="fa-solid fa-person-running"></i>
		                        </c:when>
		                        <c:when test="${buying.category eq 'game'}">
		                        	<i class="fa-solid fa-gamepad"></i>
		                        </c:when>
		                        <c:when test="${buying.category eq 'study'}">
		                        	<i class="fa-solid fa-book-open"></i>
		                        </c:when>
		                        </c:choose>
		                        </div>
		                        <div class="d-flex flex-column justify-content-evenly" style="height: 100%;">
			                        <div>
			                        	<h1 class="title">${buying.title}</h1>
			                        </div> 
			                        <div class="d-flex justify-content-between qq3">
				                        <div class="text-start">
											<p class="description" style="font-size: 1.1em">${buying.nickname}</p>
											<p class="description" style="color: black;">${buying.location}</p>
										</div>
										<div class="text-end">
											<span>
												<c:choose>
												    <c:when test="${buying.starRate==0}"><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate==1}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate==2}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate==3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate==4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate==5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i></c:when>
												    <c:when test="${buying.starRate > 0 && buying.starRate < 1}"><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate > 1 && buying.starRate < 2}"><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate > 2 && buying.starRate < 3}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate > 3 && buying.starRate < 4}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i><i class="fa-regular fa-star"></i></c:when>
												    <c:when test="${buying.starRate > 4 && buying.starRate < 5}"><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-solid fa-star"></i><i class="fa-regular fa-star-half-stroke"></i></c:when>
													<c:otherwise>
													<i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i><i class="fa-regular fa-star"></i>
													</c:otherwise>
												</c:choose>
											</span> 
											(${buying.starCount})
	                                            <p class="description" style="color: black; font-size: 2.5vh;">${buying.price}원</p>
										</div>
									</div>
								</div>
								<%-- <a href='<c:url value="/buying/detail?buyingId=${buying.buyingId}"/>' class="follow">신청하기</a> --%>
		                        <%-- <a onclick="mentorCheck(this)" data-buying-id="${buying.buyingId}" class="follow">신청하기</a> --%>
		                    </div>
		                </div>
		            </div>
		         </c:forEach>
		         <div class="row justify-content-center pt-5" id="pageMove">
		         	<%-- <div class="col-1">
		         		<a href="/HumanRental/SellingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) - 10 %>">
		         			<i class="fa-solid fa-angles-left" style="line-height: 24px;"></i>
	         			</a>
         			</div> --%>
         			<%
	        			if(request.getParameter("category") == null) {
         			%>
			        <div class="col-1">
			        	<a href="/HumanRental/BuyingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) - 1 %>">
			        		<i class="fa-solid fa-chevron-left" style="line-height: 24px;"></i>
		        		</a>
	        		</div>
	        		<%
	        			} else {
	        		%>
			        <div class="col-1">
			        	<a href="/HumanRental/BuyingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) - 1 %>&category=<%= request.getParameter("category") %>">
			        		<i class="fa-solid fa-chevron-left" style="line-height: 24px;"></i>
		        		</a>
			        </div>
			        <%
        				}	
			        %>
			        	<% 
			        		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			        		int totalPageNum = (int) request.getAttribute("totalPageNum");
			        		
			        		if(pageNum - 5 <= 0) {
			        			if(totalPageNum > pageNum + 6) { 
					        		%>
						        		<div class="col-3" style="line-height: 24px;">
					        		<% 
				        				for(int i = 1; i < pageNum + 6; i++) {
			        				%>
			        						<a href="/HumanRental/BuyingList?pageNum=<%= i %>" class="text-decoration-none"> <%= i %> </a>
			        				<%			
				        				}
					        		%>
				        				</div>
					        		<%
			        			} else {
					        		%>
						        		<div class="col-3" style="line-height: 24px;">
					        		<% 
				        				for(int i = 1; i < totalPageNum + 1; i++) {
			        				%>
			        						<a href="/HumanRental/BuyingList?pageNum=<%= i %>" class="text-decoration-none"> <%= i %> </a>
			        				<%			
				        				}
					        		%>
				        				</div>
					        		<%
			        			}
			        		} else if(pageNum - 5 > 0) {
			        			if(totalPageNum > pageNum + 6) {
					        		%>
						        		<div class="col-3" style="line-height: 24px;">
					        		<% 
				        				for(int i = pageNum - 5; i < pageNum + 6; i++) {
			        				%>
			        						<a href="/HumanRental/BuyingList?pageNum=<%= i %>" class="text-decoration-none"> <%= i %> </a>
			        				<%			
			  		      				}
					        		%>
				        				</div>
					        		<%
			        			} else { 
					        		%>
						        		<div class="col-3" style="line-height: 24px;">
					        		<% 
				        				for(int i = pageNum - 5; i < totalPageNum + 1; i++) {
			        				%>
			        						<a href="/HumanRental/BuyingList?pageNum=<%= i %>" class="text-decoration-none"> <%= i %> </a>
			        				<%			
			  		      				}
					        		%>
				        				</div>
					        		<%
			        			}
			        		}
		        		if(request.getParameter("category") == null) {
        			%>
			        <div class="col-1">
			        	<a href="/HumanRental/BuyingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) + 1 %>">
			        		<i class="fa-solid fa-chevron-right" style="line-height: 24px;"></i>
		        		</a>
			        </div>
        			<%
	        		} else {
        			%>
			        <div class="col-1">
			        	<a href="/HumanRental/BuyingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) + 1 %>&category=<%= request.getParameter("category") %>">
			        		<i class="fa-solid fa-chevron-right" style="line-height: 24px;"></i>
		        		</a>
			        </div>
        			<%
	        		}
        			%>
			        <%-- <div class="col-1">
			        	<a href="/HumanRental/SellingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) + 10 %>">
			        		<i class="fa-solid fa-angles-right" style="line-height: 24px;"></i>
		        		</a>
		        	</div> --%>
		         </div>
	        </div>
	    </div>
		<jsp:include page="footer.jsp" />
	</body>
</html>