<html>

<!-- CSS (load bootstrap) -->
<!-- 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
-->
<link rel="stylesheet" href="/lib/bootstrap-3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="/lib/angular-ngtable/ng-table.min.css">
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

<script src="/app/app.js"></script>
<script src="/app/controllers.js"></script>
<script src="/app/services.js"></script>

<script src="/app/controllers/SalesOrderController.js"></script>  
<script src="/app/controllers/SalesOrder_WorkOrdersController.js"></script>  

<body ng-app="ppla">


  <!-- NAVIGATION -->
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
      <a class="navbar-brand" ui-sref="#">PPLA Films Process Mgmt</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a ui-sref="manage/product">Products</a></li>
      <li><a ui-sref="manage/salesorder">Sales Orders</a></li>  
    </ul>
  </nav>

  <!-- Main Content -->
  <div class="container">
    <div ui-view></div>
  </div>


</body>

</html>