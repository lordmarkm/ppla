<#import "/spring.ftl" as spring />

<html>

<head>

<title>PPLA Films MES</title>
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">

<!-- CSS (load bootstrap) -->
<!-- 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
-->
<link rel="stylesheet" href="<@spring.url '/lib/bootstrap-3.0.3/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<@spring.url '/lib/angular-ngtable/ng-table.min.css' />">
<link rel="stylesheet" href="<@spring.url '/app/app.css' />">
<style>
    .navbar { border-radius:0; }
</style>

<!-- 
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.8/angular-ui-router.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular-resource.min.js"></script>
 -->
<script src="<@spring.url '/lib/angular/angular.min.js' />"></script>
<script src="<@spring.url '/lib/angular/angular-ui-router.min.js' />"></script>
<script src="<@spring.url '/lib/angular/angular-resource.min.js' />"></script>
<script src="<@spring.url '/lib/angular-ngtable/ng-table.min.js' />"></script>
<script src="<@spring.url '/lib/angular-ui/ui-bootstrap-tpls-0.11.0.min.js' />"></script>

<script src="<@spring.url '/app/app.js' />"></script>
<script src="<@spring.url '/app/controllers.js' />"></script>
<script src="<@spring.url '/app/services.js' />"></script>
<script src="<@spring.url '/app/filters.js' />"></script>

<script src="<@spring.url '/app/controllers/AuthController.js' />"></script>  
<script src="<@spring.url '/app/controllers/SalesOrderController.js' />"></script>  
<script src="<@spring.url '/app/controllers/SalesOrder_WorkOrdersController.js' />"></script>  
<script src="<@spring.url '/app/controllers/MaterialController.js' />"></script>
<script src="<@spring.url '/app/controllers/OrderItemController.js' />"></script>
<script src="<@spring.url '/app/controllers/WorkOrderBrowseController.js' />"></script>
<script src="<@spring.url '/app/controllers/WorkOrderController.js' />"></script>
<script src="<@spring.url '/app/controllers/MachineController.js' />"></script>
<script src="<@spring.url '/app/controllers/MachineHistoryController.js' />"></script>

<script src="<@spring.url '/manage/modules/users/module.js' />"></script>
<script src="<@spring.url '/manage/modules/users/controllers/UserManagementController.js' />"></script>
<script src="<@spring.url '/manage/modules/inventory/module.js' />"></script>
<script src="<@spring.url '/manage/modules/inventory/controllers/InventoryController.js' />"></script>

</head>

<body ng-app="ppla">

  <!-- NAVIGATION -->
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
      <a class="navbar-brand" href="<@spring.url '/manage' />">PPLA Films Manufacturing Execution Software</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a ui-sref="manage/salesorder">Sales Orders</a></li>
      <li><a ui-sref="manage/workorders">Work Orders</a></li>
    </ul>
    <ul class="nav navbar-nav pull-right">
      <li class="dropdown">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
          Manage<span class="caret" style="margin-left: 5px;"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <li><a ui-sref="users.list">Users</a></li>
          <!-- 
          <li><a ui-sref="manage/material">Materials</a></li>
          -->
          <li><a ui-sref="manage/machines">Machines</a>
          <!-- 
          <li><a ui-sref="manage/product">Products</a></li>
          -->
          <li><a ui-sref="inventory">Inventory</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav pull-right" ng-controller="AuthController">
      <li class="dropdown" ng-if="principal.principal">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
          {{principal.principal.username}}<span class="caret" style="margin-left: 5px;"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <li><a href="#/profile">Profile</a></li>
          <li><a href="<@spring.url '/logout' />">Logout</a></li>
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