<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial;
}

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}
</style>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container" align="center">
		<div class="tab" align="center">
			<button class="tablinks" onclick="openTab(event, 'Product')">Product</button>
			<button class="tablinks" onclick="openTab(event, 'Category')">Category</button>
			<button class="tablinks" onclick="openTab(event, 'Supplier')">Supplier</button>
		</div>

		<div id="Product" class="tabcontent">
			<c:if test="${userClickProduct==true}">
				<h3>Welcome, Enter The Product Details</h3>
				<form action="<c:url value="/admin/productsave" />" method="post"
				  enctype="multipart/form-data">
					<table align="center">
						<tr>
							<td>Product Name</td>
							<td><input type=text name="pname" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Product Description</td>
							<td><input type=text name="pdescription" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Unit Price</td>
							<td><input type=text name="unitPrice" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td><input type=text name="quantity" Class="form-control" /></td>
						</tr>
						<tr>
							<td>Supplier Name</td>
							<td><select name="supps.supid" id="supps">
									<option value="">-----------Supplier--------</option>
									<c:forEach items="${supps}" var="supps">
										<option value=${supps.supid}>${supps.supname}</option>
									</c:forEach>
							</select></td>
						</tr>
							
						<tr>
							<td>Category Name</td>
							<td><select path="category.cid"  id="cates">
									<option value="">-----------Category--------</option>
									<c:forEach items="${cates}" var="cates">
										<option value=${cates.cid}>${cates.cname}</option>
									</c:forEach>
							</select></td>
						</tr>
						
						<div class="fileinput fileinput-new"  data-provides="fileinput">
						<tr>
							<td>Image</td>
							<td><input class="form-control" type="file" name="file" accept="image/*"></td>
						</tr>
						</div>
						<tr>
							<td><input type="submit" value="Submit"
								class="btn btn-sm btn-primary"
								onClick="alert('Data Saved Sucessfully');" /></td>
							<td><input type="reset" value="Cancel" /></td>
						</tr>
					</table>
				</form>
				<br /> <br />
			<h3>
				<a href="${req}/admin/product">Display Product List</a>
			</h3>
			</c:if>
		</div>

		<div id="Category" class="tabcontent">
			<h3>Welcome, Enter The Category Details</h3>
			<form action="<c:url value="/admin/catesave" />" method="post"
				modelAttribute="cate">
				<table border="1" width="600">
					<tr>
						<td>Category ID</td>
						<td><input type=text name="cid" Class="form-control" /></td>
					</tr>
					<tr>
						<td>Category Name</td>
						<td><input type=text name="cname" Class="form-control" /></td>
					</tr>

					<tr align="center">
						<td align="center"><input type="submit" value="Submit"
							class="btn btn-sm btn-primary"
							onClick="alert('Data Saved Sucessfully');" /></td>
						<td align="center"><input type="reset" value="Reset"
							class="btn btn-sm btn-primary" /></td>
					</tr>
				</table>
			</form>
			<br /> <br />
			<h3>
				<a href="${req}/admin/category">Display Category List</a>
			</h3>
		</div>

		<div id="Supplier" class="tabcontent" align="center">
			<h3>Welcome, Enter The Supplier Details</h3>
			<form action="<c:url value="/admin/suppsave" />" method="post"
				modelAttribute="supp">
				<table border="1" width="600" align="center">

					<tr>
						<td>Supplier ID</td>
						<td><input type=text name="supid" Class="form-control" /></td>
					</tr>
					<tr>
						<td>Supplier Name</td>
						<td><input type=text name="supname" Class="form-control" /></td>
					</tr>

					<tr align="center">
						<td align="center"><input type="submit" value="Submit"
							class="btn btn-sm btn-primary"
							onClick="alert('Data Saved Sucessfully');" /></td>
						<td align="center"><input type="reset" value="Reset"
							class="btn btn-sm btn-primary" /></td>
					</tr>
				</table>
			</form>
			<br /> <br />
			<h3>
				<a href="${req}/admin/supplier">Display Supplier List</a>
			</h3>
		</div>


		<script>
			function openTab(evt, tabName) {
				var i, tabcontent, tablinks;
				tabcontent = document.getElementsByClassName("tabcontent");
				for (i = 0; i < tabcontent.length; i++) {
					tabcontent[i].style.display = "none";
				}
				tablinks = document.getElementsByClassName("tablinks");
				for (i = 0; i < tablinks.length; i++) {
					tablinks[i].className = tablinks[i].className.replace(
							" active", "");
				}
				document.getElementById(tabName).style.display = "block";
				evt.currentTarget.className += " active";
			}
		</script>
		<%@ include file="footer.jsp"%>
</body>
</html>