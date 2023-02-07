<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 등록</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>
	<form method="post">
		<c:forEach items="${foods}" var="food">
			<input type="hidden" name="name" value="${food.name}">
			<input type="hidden" name="count" value=1>
	 	 	<label><input type="checkbox" name="id" value="${food.id}">${food.name}</label>
	 	</c:forEach>
	 	<a href="/admin/foodList?id=${burgerId}">재고 관리</a>
		<input type="submit" value="레시피 등록">
	</form>
	<% if(request.getParameter("code")!=null) { %>
		<script>
			alert('<%=new ErrorCode().get(request.getParameter("code"))%>')
		</script>
	<%} %>
</body>
</html>