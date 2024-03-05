<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/save.js?ver=1"/>"></script>
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<div class="jumbotron">
	    <div class="container">
	        <h3 class="display-3">찜목록</h3>
	    </div>
	</div>
	<div class="container">
	    <div>
	        <a href="#" class="btn btn-success float-right">예약하기</a>
	    </div>
	    <div style="padding-top: 50px">
	        <table class="table table-hover">
	        <tr>
	            <th>번호</th>
	            <th>제목</th>
	            <th>카테고리</th>
	            <th>얼마?</th>
	            <th>예약</th>
	            <th>삭제</th>
	        </tr>
			<c:forEach items="${saveList}" var="savelist" varStatus="status">
	    		<tr>
	        		<td>${status.count}</td>
			 		 <c:if test="${savelist.saveListId.contains('buying')}">
						<td> <a href="<c:url value="/buying/detail?buyingId=${savelist.saveListId}"/>">${savelist.title}</a></td>
					</c:if>
					<c:if test="${savelist.saveListId.contains('selling')}">
						<td> <a href="<c:url value="/selling/detail?sellingId=${savelist.saveListId}"/>">${savelist.title}</a></td>
					</c:if>
            		<td>${savelist.category}</td>
	        		<td>${savelist.price}</td> 
					<td><a href="javascript:void(0);"  onclick="callreservationform();">예약</a></td>
					<div id="calendarForm" class="calendarForm" style="display: none;">
    					<form id="reservationForm" method="post" action="" class="form-horizontal" onsubmit="setFormAction(); return true;">
    						<input name="id" type="hidden" value="${savelist.saveListId}">
    						예약일 : <input name="date" type="date" class="date" required>
    						<br><br>
    						예약 상세 내용 : <textarea name="content" cols="50" rows="5" class="form-control" required placeholder="오후 7시부터 2시간 예약하고 싶어요"></textarea>
    						<input type="submit" value="제출">
						</form>
					</div>
	        		<td><a href="<c:url value="/save/deletesavelist?saveListId=${savelist.saveListId}"/>">삭제</a></td>
	    		</tr>
			</c:forEach>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </table>
        <a href="<c:url value="/main"/>" class="btn btn-secondary">&laquo; 메인페이지 돌아가기</a> 
    </div>
    <hr>
    <footer>
        <p>&copy; Human Rental</p>
    </footer>
</div>


</body>
</html>