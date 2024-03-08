<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
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
        <div style="padding-top: 50px">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>닉네임</th>
                        <th>카테고리</th>
                        <th>얼마?</th>
                        <th>예약</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${saveList}" var="savelist" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <c:if test="${savelist.saveListId.contains('buying')}">
                                <td> <a href="<c:url value="/buying/detail?buyingId=${savelist.saveListId}"/>">${savelist.title}</a></td>
                            </c:if>
                            <c:if test="${savelist.saveListId.contains('selling')}">
                                <td> <a href="<c:url value="/selling/detail?sellingId=${savelist.saveListId}"/>">${savelist.title}</a></td>
                            </c:if>
                            <td>${savelist.nickname}</td>
                            <td>${savelist.category}</td>
                            <td>${savelist.price}</td> 
                            <td><a href="javascript:void(0);" onclick="callreservationform('${savelist.saveListId}', '${savelist.title}');">예약</a></td>
                            <td><a href="<c:url value="/save/deletesavelist?saveListId=${savelist.saveListId}"/>">삭제</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
	<div id="calendarForm" class="calendarForm" style="display: none;">
        <form id="reservationForm" method="post" action="" class="form-horizontal" onsubmit="setFormAction(); return true;">
            <div><h3 id="reservationTitle"></h3></div>
            <br>
            <input id="reservationId" name="id" type="hidden">
            예약일 : <input name="date" type="date" class="date" required>
            <br><br>
            예약 상세 내용 : <textarea name="content" cols="50" rows="5" class="form-control" required placeholder="오후 7시부터 2시간 예약하고 싶어요"></textarea>
            <input type="submit" value="제출">
        </form>
        <br>
    </div>
	<a href="<c:url value="/main"/>" class="btn btn-secondary">&laquo; 메인페이지 돌아가기</a>
        <hr>
        <footer>
            <p>&copy; Human Rental</p>
        </footer>
    </div>
    <div id="calendarForm" class="calendarForm" style="display: none;">
        <form id="reservationForm" method="post" action="" class="form-horizontal" onsubmit="setFormAction(); return true;">
            <div><h3 id="reservationTitle"></h3></div>
            <input id="reservationId" name="id" type="hidden">
            예약일 : <input name="date" type="date" class="date" required>
            <br><br>
            예약 상세 내용 : <textarea name="content" cols="50" rows="5" class="form-control" required placeholder="오후 7시부터 2시간 예약하고 싶어요"></textarea>
            <input type="submit" value="제출">
        </form>
    </div>
</body>
</html>