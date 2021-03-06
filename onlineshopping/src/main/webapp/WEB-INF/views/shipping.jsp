<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping</title>
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
			<h1>Shipping Form</h1>
		</div>
<form action="<c:url value="/cart/updateaddr" />" method="post" modelAttribute="useraddr">
		<table border="1" width="600">
		<tr>
				<td>Customer Name</td>
				<td><input type=text name="Name" value="${useraddr.firstName} ${useraddr.lastName}"
					Class="form-control" readonly/></td>
			</tr>
			<tr>
				<td>Shipping Address</td>
				<td><textarea  rows="3" name="shippingaddress" Class="form-control" required="required">${useraddr.shippingaddress}</textarea>
					</td>
			</tr>
			<tr>
				<td>Billing Address</td>
				<td><textarea  rows="3" name="billingaddress"  Class="form-control" required="required">${useraddr.billingaddress}</textarea>
					 </td>
			</tr>
			<tr>
				<tr align="center">
					<td colspan="2" align="center"><input type="submit" value="Update Address"
						class="btn btn-sm btn-primary" onClick="alert('Address Updated Sucessfully');"/></td>
									</tr>
			</tr>
		</table>	
	</form>
	
	<br/><br/>
	<form action="<c:url value="/cart/orderprocess" />" method="post">
		 Enter Payment Methods (COD/Net Banking):
		         <select name="paymode" id="paymode" required="required">
		         	<option value="">Select Any option</option>
		         	<option value="Cash On Delivery">Cash On Delivery</option>
		         	<option value="Internet Banking">Internet Banking</option>
		         </select>
		       <br/><br/>
			<input type="submit" value="Process Order"	class="btn btn-sm btn-primary" />
	</form> 
		<br/><br/><br/><br/>	
	
  </div>
	<%@ include file="footer.jsp"%>
	</body>
	</html>
	