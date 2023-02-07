<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/list.css">
<link rel="stylesheet" href="/resources/css/adminHeader.css">
<title>LotteRia</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>	
	<div id="select-list">
		<a href="/admin/home">버거</a>
		<a href="/admin/side">사이드메뉴</a>
		<a href="/admin/drink">음료</a>
	</div>
	<div id="list-table">
	<%	if(session.getAttribute("adminName")!=null) { %>
		<div id="btn"><a href="/admin/addSide">사이드메뉴 등록</a></div>
	<%} %>
		<table>
			<thead>
				<th>사이드 메뉴 이름</th>
				<th>설명</th>
				<th>가격</th>
				<th>이미지</th>
			</thead>
			<tbody>
				<c:forEach items="${sides }" var="side">
				<%	if(session.getAttribute("adminId")!=null) { %>
					<tr style="cursor: pointer" onclick="location.href='http://localhost:8080/admin/sideDetail?sideId=${side.id}'">
				<% }else { %>
					<tr>
				<%} %>
						<td>${side.name }</td>
						<td>${side.content }</td>
						<td>${side.price }</td>
						<td><img src="${side.img }" width="100" height="100"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<% if(request.getParameter("code")!=null) { %>
		<script>
			alert('<%=new ErrorCode().get(request.getParameter("code"))%>')
		</script>
	<%} %>
</body>
</html>