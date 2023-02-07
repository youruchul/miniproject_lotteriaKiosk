<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${drink.name}</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>
	<h1>${drink.name}<h1>
	<img src="${drink.img}" />
	<p>설명 : ${drink.content}</p>
	<p>가격 : ${drink.price} </p>
	<button><a href="http://localhost:8080/admin/updateDrink?drinkId=${drink.id}"}>수정</a></button>
	<button><a href="http://localhost:8080/admin/deleteDrink?drinkId=${drink.id}" onclick="return confirm('정말 삭제하시겠습니까?');"}>삭제</a></button>
	
	<% if(request.getParameter("code")!=null) { %>
		<script>
			alert('<%=new ErrorCode().get(request.getParameter("code"))%>')
		</script>
	<%} %>
</body>
</html>