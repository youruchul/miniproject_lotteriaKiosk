<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 수정</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>
	<form method="post">
		<input name="id" value="${drink.id}" type="hidden" />
		<label for="drinkName">사이드 메뉴 이름</label>
		<input name="name" id="drinkName" placeholder="메뉴 이름을 입력해주세요." value="${drink.name}" required />
		<label for="drinkContent">설명</label>
		<input name="content" id="drinkContent" placeholder="메뉴에 대한 설명을 적어주세요." value="${drink.content}" required />
		<label for="drinkPrice">가격</label>
		<input type="number" name="price" id="drinkPrice" placeholder="가격을 입력해 주세요." value="${drink.price}" required />
		<label for="drinkImg">사진</label>
		<input name="img" id="drinkImg" placeholder="메뉴 사진을 등록해주세요." value="${drink.img}" required />
		<input type="submit" value="메뉴 수정" />
	</form>
</body>
</html>