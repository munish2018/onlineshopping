<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />
<c:set var="f"
	value="file:///E:/DT jAN 18 TO APR 18/onlineshopping/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/onlineshopping/resources/images" />



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />

<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/header.css">
<link rel="stylesheet" href="${css}/footer.css">
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src="${js}/registration.js"></script>
</head>

private String cartImage;

<body>
	<%@ include file="header.jsp"%>
	<div class="panel pannel-default">
		<div class="panel-header" align="center">
			<h1>Cart Detail</h1>
		</div>

		<table class="table table-striped" border="1" align="center">
			<tr>
				<th>Cart Id</th>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Image</th>
				<th>&#160;</th>
			</tr>
			<c:forEach items="${cartlist}" var="cartlist">
				<tr>
					<td>${cartlist.cartid}</td>
					<td>${cartlist.cartProductId}</td>
					<td>${cartlist.cartProductName}</td>
					<td>${cartlist.cartPrice}</td>
					<td>${cartlist.cartQuantity}</td>
					<td><img src="${f}/${cartlist.cartImage}" width=50 height=50></td>
					<td><a href="${req}/cart/deletecart/${cartlist.cartid}" class="btn btn-sm btn-primary">Remove</a>&#160;</td>
	            </tr>
			</c:forEach>
			<tr><td><a href="${req}/" class="btn btn-sm btn-primary">Continue Shopping</a></td></tr>
			<tr><td><a href="${req}/cart/checkout" class="btn btn-sm btn-primary">Check Out</a></td></tr>
		</table>
	</div>
		<%@ include file="footer.jsp"%>
</body>
</html>
