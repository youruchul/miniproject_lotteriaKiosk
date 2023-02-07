<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id="choice-item">
	<table>
		<thead>
			<th>이름</th>
			<th>가격</th>
			<th>수량</th>
		</thead>
		<tbody>
			<c:set var="totalCount" value="0" />
			<c:set var="totalPrice" value="0" />
			<c:forEach items="${choose }" var="choice">
			<c:if test="${choice.categoryId eq 1 }">
			<div id="choice-item">
				<tr>
					<td>${burgers[choice.itemId-1].name}</td>
					<td>${burgers[choice.itemId-1].price }</td>
					<td>${choice.count }</td>
					<c:set var="totalCount" value="${totalCount+choice.count }" />
					<c:set var="totalPrice" value="${totalPrice+(burgers[choice.itemId-1].price)*choice.count }" />
				</tr>
			</c:if>
			<c:if test="${choice.categoryId eq 2 }">
				<tr>
					<td>${drinks[choice.itemId-1].name }</td>
					<td>${drinks[choice.itemId-1].price }</td>
					<td>${choice.count }</td>
					<c:set var="totalCount" value="${totalCount+choice.count }" />
					<c:set var="totalPrice" value="${totalPrice+(drinks[choice.itemId-1].price)*choice.count }" />
				</tr>
			</c:if>
			<c:if test="${choice.categoryId eq 3 }">
				<tr>
					<td>${sides[choice.itemId-1].name }</td>
					<td>${sides[choice.itemId-1].price }</td>
					<td>${choice.count }</td>
					<c:set var="totalCount" value="${totalCount+choice.count }" />
					<c:set var="totalPrice" value="${totalPrice+(sides[choice.itemId-1].price)*choice.count }" />
				</tr>
			</c:if>
			<c:if test="${choice.categoryId eq 0 }">
				<tr>
					<c:set var="setDiscountName" value="세트할인" />
					<c:set var="setDiscountPrice" value="-2000" />
					<td>${setDiscountName }</td>
					<td>${setDiscountPrice }</td>
					<td>${choice.count }</td>
					<c:set var="totalCount" value="${totalCount+choice.count }" />
					<c:set var="totalPrice" value="${totalPrice+(setDiscountPrice)*choice.count }" />
				</tr>
			</c:if>
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="total-item">
	<table>
		<thead>
			<th>수량</th>
			<th>가격</th>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${totalCount}" /> </td>
				<td><c:out value="${totalPrice}" /> </td>
			</tr>
		</tbody>
	</table>
</div>
