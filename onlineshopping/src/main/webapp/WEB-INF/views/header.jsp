<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set var="req" value="${pageContext.request.contextPath}" />
<spring:url value="/resources/css" var="css" />
<link rel="stylesheet" href="${css}/header.css">
<nav class="navbar navbar-inverse fixed-top" >  
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Stop To Shop</a>
    </div>
   <div class="container-fluid">
       <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${req}/">Home</a></li>
        <li class="active"><a href="${req}/admin">Admin</a></li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="active"><a href="${req}/admin/product">Manage Products</a></li>
        </sec:authorize>
        <li class="active"><a href="${req}/listproduct">List Products</a></li>
        <!-- 
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
         -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="${req}/register">Sign Up</a></li>
        <li><a href="${req}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
      </div>
  </div>
 </nav>
