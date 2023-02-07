<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="header">
	<a href="/admin/home"><img src="https://www.lotteria.com/Images/main/logo.gif"></a>

<%	if(session.getAttribute("adminName")!=null) { %>
		<div id="user-btn">
			<a href="/">처음으로</a>
			<a href="/admin/foodList?id=">재고 관리</a>
			<a href="/admin/logout">로그아웃</a>
		</div>
<% }else { %>
		<div id="user-btn">
			<a href="/">처음으로</a>
			<a href="/admin/login">로그인</a>
			<a href="/admin/signup">회원가입</a>
		</div>
	<%} %>
</div>
<div id="hello-msg">
	<%	if(session.getAttribute("adminName")!=null) { %>
			<h3><%= session.getAttribute("adminName") %>님 환영합니다!!!</h3>
	<% }else { %>
			<h3>롯데리아에 오신 것을 환영합니다!!!</h3>
	<%} %>
</div>
