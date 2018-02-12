<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />
<c:set var="f" value="file:///E:/DT jAN 18 TO APR 18/onlineshopping/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/onlineshopping/resources/images" />



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
			<h1>Product Detail</h1>
		</div>
<form  method="post" modelAttribute="product" enctype="multipart/form-data">
			<table border="1" width="600">
				<tr>
				<td rowspan=5><img src="${f}/${product.imageurl}.jpg" width=400 height=400 /></td>
					<td>Product ID</td>
					<td><input type=text name="pid" value="${product.pid}"
						Class="form-control" /></td>
										</tr>
				<tr>
					<td>Product Name</td>
					<td><input type=text name="pname" value="${product.pname}"
						Class="form-control" /></td>
				</tr>
				<tr>
					<td>Product Description</td>
					<td><input type=text name="pdescription"
						value="${product.pdescription}" Class="form-control" /></td>
				</tr>
				<tr>
					<td>Product Quantity</td>
					<td><input type=text name="quantity"
						value="${product.quantity}" Class="form-control" /></td>
				</tr>
				<tr>
					<td>Product Unit price</td>
					<td><input type=text name="unitPrice"
						value="${product.unitPrice}" Class="form-control" /></td>
				</tr>
				<tr align="center">
					<td colspan="2" align="center"><input type="submit" value="Add To Cart"
						class="btn btn-sm btn-primary"/></td>
									</tr>
			</table>
		</form>
		<br/><br/><br/><br/><br/>
	</div>
<%@ include file="footer.jsp"%>
</body>
</html>
