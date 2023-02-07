<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/list.css">
<link rel="stylesheet" href="/resources/css/bottom.css">
<title>Insert title here</title>
</head>
<body>
<div id="list-table">
	<table>
		<thead>
			<th>음료이름</th>
			<th>설명</th>
			<th>가격</th>
			<th>이미지</th>
		</thead>
		<tbody>
			<c:forEach items="${drinks }" var="drink">
				<tr>
					<td>${drink.name }</td>
					<td>${drink.content }</td>
					<td>${drink.price }</td>
					<td><a href="/kiosk/insertDrink?drinkId=${drink.id}"><img src="${drink.img }" width="100" height="100"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="bottom-table">
	<%@ include file="../fix/bottom.jsp" %>
</div>
</body>
</html>