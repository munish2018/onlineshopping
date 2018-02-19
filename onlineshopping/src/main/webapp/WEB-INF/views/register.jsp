<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />

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

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<form action="<c:url value="/userdetsave" />" method="post" modelAttribute="udet">
					<table align="center">
						<tr>
							<td>E Mail </td>
							<td><input type="email" name="email" Class="form-control" required="required"/></td>
						</tr>
						<tr>
							<td>Password </td>
							<td><input type=password name="password"
								Class="form-control" required="required" /></td>
						</tr>
						<tr>
							<td>First Name</td>
							<td><input type=text name="firstName" Class="form-control" required="required"/></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><input type=text name="lastName" Class="form-control" required="required" /></td>
						</tr>
						<tr>
							<td>Contact Number</td>
							<td><input type=number name="contactNumber" Class="form-control"  pattern="[0-9]{10}" required="required"/></td>
						</tr>
						<tr>
							<td>Shipping Address</td>
							<td><textarea rows="3" cols=""name="shippingaddress" Class="form-control" required="required"></textarea>
						</tr>
						<tr>
							<td>Billing Address</td>
							<td><textarea rows="3" cols=""name="billingaddress" Class="form-control" required="required"></textarea>
						</tr>
							<tr>
							<td><input type="submit" value="Submit"
								class="btn btn-sm btn-primary"
								onClick="alert('Data Saved Sucessfully');" /></td>
								<td><input type="reset" value="Cancel" /></td>
						</tr>
					</table>
				</form>
				<br/><br/><br/><br/>
				
				<!-- ends register form -->

				<script type="text/javascript">
					document
							.getElementById("field_terms")
							.setCustomValidity(
									"Please indicate that you accept the Terms and Conditions");
				</script>
			</div>
			<!-- ends col-6 -->
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>