<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
	        		<td><a href="">예약</a></td>
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