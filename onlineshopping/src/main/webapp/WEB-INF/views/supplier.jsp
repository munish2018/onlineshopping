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
			<h1>Supplier Form</h1>
		</div>

		<table class="table table-striped" border="1" align="center">
			<tr>
				<th>Supplier Id</th>
				<th>Supplier Name</th>
				<th>&#160;</th>
			</tr>
			<c:forEach items="${supps}" var="supps">
				<tr>
					<td>${supps.supid}</td>
					<td>${supps.supname}</td>
					<td><a href="${req}/admin/supplier/${supps.supid}"
						class="btn btn-sm btn-primary">View</a>&#160; <a
						href="${req}/admin/deletesupp/${supps.supid}"
						class="btn btn-sm btn-primary">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
	<form action="<c:url value="/admin/suppupdate" />" method="post"
		modelAttribute="supp">
		<table border="1" width="600">

			<tr>
				<td>Supplier ID</td>
				<td><input type=text name="supid" value="${supp.supid}"
					Class="form-control" /></td>
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td><input type=text name="supname" value="${supp.supname}"
					Class="form-control" /></td>
			</tr>

			<tr align="center">
				<td align="center"><input type="submit" value="Submit"
					class="btn btn-sm btn-primary"
					onClick="alert('Data Updated Sucessfully');" /></td>
				<td align="center"><input type="reset" value="Reset"
					class="btn btn-sm btn-primary" /></td>
			</tr>
		</table>
	</form>
	</div>
	<%@ include file="footer.jsp"%>
	</body>
	</html>
	