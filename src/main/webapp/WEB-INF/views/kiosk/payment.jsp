<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../fix/kioskHeader.jsp" %>
	<p>최종 주문내역입니다.</p>
	<%@ include file="../fix/bottom.jsp" %>
	<p>적용하신 쿠폰은 < ${coupon.name } > 입니다.</p>
	<p>${coupon.percent }% 할인되어</p>
	<p>최종금액 ${totalPrice-(totalPrice*coupon.percent/100)} 입니다.</p>
	<a href="/kiosk/insertOrder?orderNumber=${orderNumber}&totalCount=${totalCount}&totalPrice=${totalPrice}"><img src="https://image.lottecard.co.kr/webapp/pc/images/conven/csappcard/img_lc8122_step3.jpg"></a>
</body>
</html>