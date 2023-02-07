<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버거 추가</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>
	<form method="post">
		<label for="burgerName">버거 이름</label>
		<input name="name" id="burgerName" placeholder="버거 이름을 입력해주세요." required />
		<label for="burgerContent">설명</label>
		<input name="content" id="burgerContent" placeholder="버거에 대한 설명을 적어주세요." required />
		<label for="burgerPrice">가격</label>
		<input type="number" name="price" id="burgerPrice" placeholder="가격을 입력해 주세요." required />
		<label for="burgerSingleImg">단품 사진</label>
		<input name="singleImg" id="burgerSingleImg" placeholder="맛있는 버거 사진을 등록해주세요." required />
		<label for="burgerImg">세트 사진</label>
		<input name="burgerSetImg" id="burgerSetImg" placeholder="맛있는 버거 사진을 등록해주세요." required />
		<input type="submit" value="버거 등록">
	</form>
</body>
</html>