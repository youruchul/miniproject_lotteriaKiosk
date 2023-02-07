<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재료 추가</title>
</head>
<body>
	<%@ include file="../fix/header.jsp" %>
	<form method="post">
		<label for="foodName">재료</label>
		<input name="name" id="foodName" placeholder="재료 이름을 입력해주세요." required />
		<label for="foodCount">재고</label>
		<input type="number" name="count" id="foodCount" placeholder="재료 재고를 적어주세요." required />
		<input type="submit" value="재료 추가">
	</form>
	<% if(request.getParameter("code")!=null) { %>
		<script>
			alert('<%=new ErrorCode().get(request.getParameter("code"))%>')
		</script>
	<%} %>
</body>
</html>