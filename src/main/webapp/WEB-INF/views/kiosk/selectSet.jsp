<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/select.css">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="select-area">
			<a href="/kiosk/home"><div id="select-opt1"><p>단품</p><img src="${burger.singleImg }"></div></a>
			<a href="/kiosk/insertSetDiscount"><div id="select-opt2"><p>세트</p><img src="${burger.setImg }"> </div></a>
		</div>
	</div>
</body>	
</html>