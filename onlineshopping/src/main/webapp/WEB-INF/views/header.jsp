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
        <!--   <li class="active"><a href="${req}/listproduct">List Products</a></li> -->
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">List Products <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <c:forEach items="${cates}" var="cates">
			<li><a href="${req}/listproduct/${cates.cid}"
						class="btn btn-sm btn-primary">${cates.cname}</a></li>
			</c:forEach>
          </ul>
        </li>
        <!-- 
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
         -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="active">
        <c:if test='<%=(Boolean)session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true%>'>
        <sec:authentication var="user" property="principal" />
         <a> Welcome ${user.username}</a>
        </c:if>
        </li>
        <li class="active"><a href="${req}/register">Sign Up</a></li>
        <li><a href="${req}/gotologin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <c:if test='<%=(Boolean)session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true%>'>
        <li><a href="${req}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </c:if>
      </ul>
      </div>
  </div>
 </nav>
