
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/resources/js" var="js" />

<c:set var="req" value="${pageContext.request.contextPath}" />
<spring:url value="/resources/images/product" var="productImages" />

<script src="${js}/angular.js"></script>
<script src="${js}/angular.min.js"></script>

<div ng-app="myApp" ng-controller="myCtrl" ng-init="test='${pid}'">

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<p>
Search:<input type="text" ng-model="test" class="form-control" id="product" />
	</p>

	<table border="1" width="50%"
		class="table table-hover table-responsive">
		<tr>
			<th ng-click="orderByMe('pid')">Product ID</th>
			<th ng-click="orderByMe('pname')">Product Name</th>
			<th ng-click="orderByMe('pdescription')">Product Decsription</th>
			<th ng-click="orderByMe('unitPrice')">Product Price</th>
			<th ng-click="orderByMe('quantity')">Product Quantity</th>
			<th ng-click="">Image</th>
			<th ng-click=""></th>
		</tr>

		<tr ng-repeat="x in names | orderBy:myOrderBy | filter:test">
			<td>{{x.pid}}</td>
			<td>{{x.pname}}</td>
			<td>{{x.pdescription}}</td>
			<td>{{x.unitPrice}}</td>
			<td>{{x.quantity}}</td>
			<td><img ng-src="${productImages}/{{x.imageurl}}.jpg" width="50"	height="50"></td>
			<td><a ng-href="${req}/listproductbypid/{{x.pid}}"
				class="btn btn-info" role="button">View</a></td>
		</tr>
	</table>
</div>
<script>
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope, $http) {
		$http.get("/displayallprod").then(function(response) 
		{
			$scope.names = response.data;
		});
		$scope.orderByMe = function(x) {
			$scope.myOrderBy = x;
		}
	});
</script>

<div class="panel panel-default" id="footer" style="background:#ffab62;	width:100%;	height:20px;position:absolute;bottom:0;	left:0;">
    <div class="panel-footer">Copyright © 2010 Shopping Inc. All rights reserved.</div>
</div>


