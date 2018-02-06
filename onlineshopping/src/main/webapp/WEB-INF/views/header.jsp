<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
        <li class="active"><a href="${req}/register">Register</a></li>
        <li class="active"><a href="${req}/signin">Sign In</a></li>
        <li class="active"><a href="${req}/admin">Admin</a></li>
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
      <!-- 
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
       -->
    </div>
  </div>
 </nav>
