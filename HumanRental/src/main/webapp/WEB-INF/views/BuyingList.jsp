<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<title>휴먼렌탈</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/style_menteelist.css"/>">
		<script src="<c:url value="/resources/js/myPage.js"/>"></script>
		<script src="<c:url value="/resources/js/buyingList.js"/>"></script>
	</head>
	
	<body>
		<jsp:include page="nav.jsp" />
		<div class="qqml2 container">
	        <div class="text-center fs-1 p-3">
	            <div class="p-3">멘토 모집</div>
	        </div>
	        <div class="category pt-3">
	            <div class="btn btn-light fs-1"><a href="<c:url value="/BuyingList?category=music"/>"><i class="fa-solid fa-guitar"></i></a></div>
	            <div class="btn btn-light fs-1"><a href="<c:url value="/BuyingList?category=sports"/>"><i class="fa-solid fa-person-running"></i></a></div>
	            <div class="btn btn-light fs-1"><a href="<c:url value="/BuyingList?category=game"/>"><i class="fa-solid fa-gamepad"></i></a></div>
	            <div class="btn btn-light fs-1"><i class="fa-solid fa-comments"></i></div>
	            <div class="btn btn-light fs-1"><i class="fa-solid fa-car"></i></div>
	            <div class="btn btn-light fs-1"><i class="fa-solid fa-book-open"></i></div>
	            <div class="btn btn-light"><a href="<c:url value="/BuyingList?pageNum=1"/>" class="fs-4 text-decoration-none">전체</a></div>
	<%--             <div><a href="<c:url value="/buying" />"><h4>쓰기</h4></a></div> --%>
	            <div btn fs-1><a onclick="menteeCheck2()" class="fs-4 text-decoration-none">쓰기</a></div>
	        </div>
	        <div class="qq1 row">
		        <c:forEach items="${buyinglist}" var="buying">
		            <div class="qq2 col-3">
		                <div class="wrapper border" onclick="mentorCheck(this)" data-buying-id="${buying.buyingId}" style="height: 18vh;">
		                    <div class="image-wrapper h-100 d-flex flex-column justify-content-between">
		                    	<div>
			                    	<c:choose>
				                    	<c:when test="${buying.category eq 'music'}">
				                        	<i class="fa-solid fa-guitar fs-1"></i>
				                        </c:when>
				                        <c:when test="${buying.category eq 'sports'}">
				                        	<i class="fa-solid fa-person-running fs-1"></i>
				                        </c:when>
				                        <c:when test="${buying.category eq 'game'}">
				                        	<i class="fa-solid fa-gamepad fs-1"></i>
				                        </c:when>
			                        </c:choose>
		                        </div>
		                        <div>
		                        	<h1 class="name fs-5">${buying.title}</h1>
		                        </div> 
		                        <div>
									<p class="description">${buying.nickname}</p>
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
			        <div class="col-1">
			        	<a href="/HumanRental/BuyingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) - 1 %>">
			        		<i class="fa-solid fa-chevron-left" style="line-height: 24px;"></i>
		        		</a>
	        		</div>
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
			        	%>
			        <div class="col-1">
			        	<a href="/HumanRental/BuyingList?pageNum=<%= Integer.parseInt(request.getParameter("pageNum")) + 1 %>">
			        		<i class="fa-solid fa-chevron-right" style="line-height: 24px;"></i>
		        		</a>
			        </div>
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