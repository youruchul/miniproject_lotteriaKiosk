<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/list.css">
<link rel="stylesheet" href="/resources/css/bottom.css">
<link rel="stylesheet" href="/resources/css/kioskHeader.css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../fix/kioskHeader.jsp" %>
<div id="list-table">
	<table>
		<thead>
			<th>버거이름</th>
			<th>설명</th>
			<th>가격</th>
			<th>이미지</th>
		</thead>
		<tbody>
			<c:forEach items="${ableBurgers }" var="burger">
				<tr>
					<td>${burger.name }</td>
					<td>${burger.content }</td>
					<td>${burger.price }</td>
					<td><a href="/kiosk/insertBurger?burgerId=${burger.id }"><img src="${burger.singleImg }" width="100" height="100"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="bottom-table">
	<%@ include file="../fix/bottom.jsp" %>
	<div id="pay-btn"><a href="/kiosk/coupon">결제하기</a></div>
</div>
	
</body>
</html>