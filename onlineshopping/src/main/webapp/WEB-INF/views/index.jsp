<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<head>

  <title>Bootstrap Example</title>
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
<%@ include file = "header.jsp" %>
<%@ include file = "carousal.jsp" %>
<%@ include file = "footer.jsp" %>
</body>
</html>
