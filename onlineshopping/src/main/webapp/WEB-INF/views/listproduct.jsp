<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />
<c:set var="f" value="file:///E:/DT jAN 18 TO APR 18/onlineshopping/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/onlineshopping/resources/images" />

<c:set var="img" value="/resources/images" />

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

		<table class="table table-striped" border="1" align="center">
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Description</th>
				<th>Image</th>
				<th>&#160;</th>
			</tr>
			<c:forEach items="${products}" var="products">
				<tr>
					<td>${products.pid}</td>
					<td>${products.pname}</td>
					<td>${products.pdescription}</td>
					<td><img src="${req}/resources/images/${products.imageurl}.jpg" width=40 height=40/></td>
					<td><a href="${req}/listproductbypid/${products.pid}"
						class="btn btn-sm btn-primary">View</a>&#160;</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		
	<%@ include file="footer.jsp"%>
</body>
</html>
