<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />


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
<body>
	<%@ include file="header.jsp"%>
	<div class="panel pannel-default">
		<div class="panel-header" align="center">
			<h1>Order Detail</h1>
		</div>
	<h1>Customer Detail</h1>	
	<hr/>
	 <table border="1" width="600">
		<tr>
				<td>Name</td>
				<td><input type=text name="firstName" value="${userdet.firstName} ${userdet.lastName}" /></td>
			</tr>
			<tr>
				<td>Shipping Address</td>
				<td><textarea  rows="3" name="shippingaddress">${userdet.shippingaddress}</textarea>
					</td>
			</tr>
			<tr>
				<td>Billing Address</td>
				<td><textarea  rows="3" name="billingaddress">${userdet.billingaddress}</textarea>
					 </td>
			</tr>
	</table>
	<h1>Product Detail</h1>	
	<hr/>	
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
			<% 
			 double total=0;
			  %>
			<c:forEach items="${cartlist}" var="cartlist">
				<tr>
					<td>${cartlist.cartid}</td>
					<td>${cartlist.cartProductId}</td>
					<td>${cartlist.cartProductName}</td>
					<td>${cartlist.cartPrice}</td>
					<td>${cartlist.cartQuantity}</td>
				   <td><img src="${f}/${cartlist.cartImage}" width=50 height=50></td>
	            </tr>
			</c:forEach>
		</table>
		<table border="1" width="600">
		<tr>
				<td>Payment Mode</td>
				<td><input type=text name="Payment Mode :" value="${orddet.payment}" /></td>
			</tr>
		<tr>
				<td>Total Payment </td>
				<td><input type=text name="total" value="${orddet.total}" /></td>
			</tr>
	</table>
	<br/><br/><br/>
	<a href="${req}/cart/thanku" class="btn btn-sm btn-primary">Proceed</a>
		<br/><br/><br/>
	</div>
	<%@ include file="footer.jsp"%>
	</body>
	</html>
	