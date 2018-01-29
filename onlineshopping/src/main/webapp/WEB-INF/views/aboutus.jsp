<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>About Us</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />

<link rel="stylesheet" href="${css}/bootstrap.min.css">
<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<link rel="stylesheet" href="${css}/footer.css">

</head>
<body>
	<%@ include file="header.jsp"%>
	<div>Watch Shop is an official stocklist for all watch brands
		listed on this website. Established in 2005 on the Abu Lane,
		Meerut(U.P) India , Watch Shop is a leading retailer of brand name
		designer watches and is also the India's most popular watch website.</div>
	<%@ include file="footer.jsp"%>
</body>
</html>

