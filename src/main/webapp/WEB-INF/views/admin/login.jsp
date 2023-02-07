<%@ page import="com.lotteria.kiosk.exception.ErrorCode" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form method="post">
		<label for="login-adminId">아이디</label>
		<input name="adminId" id="login-adminId" placeholder="아이디를 입력해주세요." required />
		<label for="login-adminPW">비밀번호</label>
		<input type="password" name="adminPW" id="login-adminPW" placeholder="비밀번호를 입력해주세요." required />
		<input type="submit" value="로그인" />
	</form>
	<% if(request.getParameter("code")!=null) { %>
		<script>
			alert('<%=new ErrorCode().get(request.getParameter("code"))%>')
		</script>
	<%} %>
</body>
</html>