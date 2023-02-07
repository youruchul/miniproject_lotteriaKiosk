<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${side.name}</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>
	<h1>${side.name}<h1>
	<img src="${side.img}" />
	<p>설명 : ${side.content}</p>
	<p>가격 : ${side.price} </p>
	<button><a href="http://localhost:8080/admin/updateSide?sideId=${side.id}"}>수정</a></button>
	<button><a href="http://localhost:8080/admin/deleteSide?sideId=${side.id}" onclick="return confirm('정말 삭제하시겠습니까?');"}>삭제</a></button>
	
	<% if(request.getParameter("code")!=null) { %>
		<script>
			alert('<%=new ErrorCode().get(request.getParameter("code"))%>')
		</script>
	<%} %>
</body>
</html>