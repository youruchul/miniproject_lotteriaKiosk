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
<title>재고 관리</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>
	 	<table>
		<thead>
			<th>재료</th>
			<th>수량</th>
		</thead>
		<tbody>
			<c:forEach items="${foods }" var="food">
				<tr onclick="location.href='http://localhost:8080/admin/updateFood?foodId=${food.id}&pid=${id}'">
					<td>${food.name }</td>
					<td>${food.count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/admin/addFood?id=${id}">재료 추가</a>
	<% if(request.getParameter("code")!=null) { %>
		<script>
			alert('<%=new ErrorCode().get(request.getParameter("code"))%>')
		</script>
	<%} %>
</body>
</html>