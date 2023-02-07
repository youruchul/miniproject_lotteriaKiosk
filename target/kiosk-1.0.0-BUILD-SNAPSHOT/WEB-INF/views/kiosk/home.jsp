<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<th>버거이름</th>
			<th>설명</th>
			<th>가격</th>
			<th>이미지</th>
		</thead>
		<tbody>
			<c:forEach items="${burgers }" var="burger">
				<tr>
					<td>${burger.name }</td>
					<td>${burger.content }</td>
					<td>${burger.price }</td>
					<td><a href="/kiosk/selectSet?burgerId=${burger.id }"><img src="${burger.singleImg }" width="100" height="100"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>