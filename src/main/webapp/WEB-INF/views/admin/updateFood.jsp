<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 수정</title>
</head>
<body>
<p>${food.id }</p>
	<%@ include file="../fix/header.jsp" %>
	<form method="post">
		<input name="id" value="${food.id}" type="hidden" />
		<label for="foodName">재료 이름</label>
		<input name="name" id="foodName" placeholder="메뉴 이름을 입력해주세요." value="${food.name}" required />
		<label for="foodCount">수량</label>
		<input type="number" name="count" id="foodCount" placeholder="수량을 입력해 주세요." value="${food.count}" required />
		<input type="submit" value="재고 수정" />
	</form>
</body>
</html>