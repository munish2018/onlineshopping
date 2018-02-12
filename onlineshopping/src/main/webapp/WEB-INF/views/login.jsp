<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login--- ${req}</title>
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />

<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/signinstyle.css">
<link rel="stylesheet" href="${css}/footer.css">
<script src="${js}/bootstrap.min.js"></script>


<link href="favicon.ico" rel="shortcut icon" type="${images}/x-icon" />
</head>
<body>
 	<%@ include file="header.jsp"%>
	<% 
	String un="${username}";
	session.setAttribute("username",un);
	%>
	<div class="login" align="center">
			<h1 class="loginheading">Login</h1>
			<table align="center">
			<tr>
			<td>
			<c:if test="${not empty message}">
			<div class="alert alert-danger">${message}</div> 
			</c:if>
			</td>
			</tr>
			</table>
			<form action="${pageContext.request.contextPath }/login" class="form-signin" method="post">
					<div class="form-group emailInput has-feedback">
					<label for="email">Email</label> 
					<input type="email"	class="form-control" name="username" id="username"
						placeholder="Please Enter E Mail ID...">
				</div>
				<div class="form-group nameInput has-feedback">
					<label for="name">Password</label> <input type="password" 
						class="form-control" name="password" id="password"
						placeholder="Please Enter Password...">
				</div>
				
				<button type="submit" class="btn btn-default">Submit</button>
				<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<p class="text-muted loginbottomtext">©shop</p>
			</form>
			</div>
	<%@ include file="footer.jsp"%>
</body>
</html>