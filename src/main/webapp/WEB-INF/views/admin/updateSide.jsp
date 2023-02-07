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
		<input name="id" value="${side.id}" type="hidden" />
		<label for="sideName">사이드 메뉴 이름</label>
		<input name="name" id="sideName" placeholder="메뉴 이름을 입력해주세요." value="${side.name}" required />
		<label for="sideContent">설명</label>
		<input name="content" id="sideContent" placeholder="메뉴에 대한 설명을 적어주세요." value="${side.content}" required />
		<label for="sidePrice">가격</label>
		<input type="number" name="price" id="sidePrice" placeholder="가격을 입력해 주세요." value="${side.price}" required />
		<label for="sideImg">사진</label>
		<input name="img" id="sideImg" placeholder="메뉴 사진을 등록해주세요." value="${side.img}" required />
		<input type="submit" value="메뉴 수정" />
	</form>
</body>
</html>