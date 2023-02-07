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
			<th>음료이름</th>
			<th>설명</th>
			<th>가격</th>
			<th>이미지</th>
		</thead>
		<tbody>
			<c:forEach items="${drinks }" var="drink">
				<tr>
					<td>${drink.name }</td>
					<td>${drink.content }</td>
					<td>${drink.price }</td>
					<td><a href="/kiosk/selectSet?burgerId=${burger.id }"><img src="${drink.img }" width="100" height="100"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<thead>
			<th>사이드이름</th>
			<th>설명</th>
			<th>가격</th>
			<th>이미지</th>
		</thead>
		<tbody>
			<c:forEach items="${sides }" var="side">
				<tr>
					<td>${side.name }</td>
					<td>${side.content }</td>
					<td>${side.price }</td>
					<td><a href="/kiosk/selectSet?burgerId=${burger.id }"><img src="${side.img }" width="100" height="100"></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>