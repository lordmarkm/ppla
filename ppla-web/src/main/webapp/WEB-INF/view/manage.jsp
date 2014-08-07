<html>

<head>

<title>PPLA Films MES</title>
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">

<!-- CSS (load bootstrap) -->
<!-- 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
-->
<link rel="stylesheet" href="/lib/bootstrap-3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="/lib/angular-ngtable/ng-table.min.css">
<link rel="stylesheet" href="/app/app.css">
<style>
    .navbar { border-radius:0; }
</style>

<!-- 
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.8/angular-ui-router.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular-resource.min.js"></script>
 -->
<script src="/lib/angular/angular.min.js"></script>
<script src="/lib/angular/angular-ui-router.min.js"></script>
<script src="/lib/angular/angular-resource.min.js"></script>
<script src="/lib/angular-ngtable/ng-table.min.js"></script>
<script src="/lib/angular-ui/ui-bootstrap-tpls-0.11.0.min.js"></script>

<script src="/app/app.js"></script>
<script src="/app/controllers.js"></script>
<script src="/app/services.js"></script>

<script src="/app/controllers/AuthController.js"></script>  
<script src="/app/controllers/SalesOrderController.js"></script>  
<script src="/app/controllers/SalesOrder_WorkOrdersController.js"></script>  
<script src="/app/controllers/MaterialController.js"></script>
<script src="/app/controllers/OrderItemController.js"></script>
<script src="/app/controllers/WorkOrderBrowseController.js"></script>
<script src="/app/controllers/WorkOrderController.js"></script>
<script src="/app/controllers/MachineController.js"></script>

</head>

<body ng-app="ppla">

  <!-- NAVIGATION -->
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
      <a class="navbar-brand" href="/manage">PPLA Films Manufacturing Execution Software</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a ui-sref="manage/material">Materials</a></li>
      <li><a ui-sref="manage/machines">Machines</a>
      <li><a ui-sref="manage/product">Products</a></li>
      <li><a ui-sref="manage/salesorder">Sales Orders</a></li>
      <li><a ui-sref="manage/workorders">Work Orders</a></li>  
    </ul>
    <ul class="nav navbar-nav pull-right" ng-controller="AuthController">
      <li class="dropdown" ng-if="principal.principal">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
          {{principal.principal.username}}<span class="caret" style="margin-left: 5px;"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <li><a href="#/profile">Profile</a></li>
          <li><a href="/logout">Logout</a></li>
        </ul>
      </li>
    </ul>
  </nav>

  <!-- Main Content -->
  <div class="container">
    <div ui-view></div>
  </div>

  <div style="margin-bottom: 30px;"></div>
</body>

</html>