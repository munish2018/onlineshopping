<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />

<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/signinstyle.css">
<link rel="stylesheet" href="${css}/footer.css">
<script src="${js}/jquery-2.1.4.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src="${js}/signinscript.js"></script>

<link href="favicon.ico" rel="shortcut icon" type="${images}/x-icon" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="login" align="center">
			<h1 class="loginheading">Login</h1>
			<table align="center">
			<form method="post" action="">
				
				<div class="form-group emailInput has-feedback">
					<label for="email">Email</label> <input type="email"
						class="form-control" name="email" id="email"
						placeholder="Please Enter E Mail ID...">
				</div>
				<div class="form-group nameInput has-feedback">
					<label for="name">Password</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="Please Enter Password...">
				</div>
				
				<button type="submit" class="btn btn-default">Submit</button>
				<p class="loginbottomtext">
					Still don't have an account? <a href="register">Register</a>
				</p>
			</form>
			</table>
			<!-- ©©© COPYRIGHT ©©©-->
			<p class="text-muted loginbottomtext">©shop</p>
		</div>
	
	<%@ include file="footer.jsp"%>
</body>
</html>