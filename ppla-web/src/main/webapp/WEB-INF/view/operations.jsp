<#import "/spring.ftl" as spring />

<html>

<head>
<!-- CSS (load bootstrap) -->
<!-- 
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
-->
<title>PPLA Films MES</title>
<link rel="icon" type="image/x-icon" href="<@spring.url '/images/favicon.ico' />" />
<link rel="stylesheet" href="<@spring.url '/lib/bootstrap-3.2.0/css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<@spring.url '/lib/angular-ngtable/ng-table.min.css' />" />
<link rel="stylesheet" href="<@spring.url '/lib/angular-quick-date/ng-quick-date.css' />" />
<link rel="stylesheet" href="<@spring.url '/lib/angular-quick-date/ng-quick-date-default-theme.css' />" />
<link rel="stylesheet" href="<@spring.url '/lib/font-awesome-4.1.0/css/font-awesome.min.css' />" />
<link rel="stylesheet" href="<@spring.url '/app/app.css' />" />
<script src="<@spring.url '/lib/jquery/jquery.min.js' />"></script>
<style>
    .navbar { border-radius:0; }
</style>
<script data-main="<@spring.url '/operations/main.js' />" src="<@spring.url '/lib/require/require.js' />"></script>
</head>

<body>

  <!-- NAVIGATION -->
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
      <a class="navbar-brand" href="<@spring.url '/auth/redirect' />">PPLA Films Manufacturing Execution Software</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a ui-sref="workorders">Work Orders</a></li>
    </ul>

    <!-- 
    <ul class="nav navbar-nav pull-right">
      <li class="dropdown">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
          Roles<span class="caret" style="margin-left: 5px;"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <li><a ui-sref="warehouse.workorder">Warehouse</a></li>
          <li><a ui-sref="mixer.identity">Mixer</a></li>
          <li><a ui-sref="extruder.identity">Extruder</a></li>
          <li><a ui-sref="printer.identity">Printer</a>
          <li><a ui-sref="cutter.identity">Cutter</a>
        </ul>
      </li>
    </ul>
    -->
    <ul class="nav navbar-nav pull-right" ng-controller="AuthController">
      <li class="dropdown" ng-if="principal.principal">
        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
          {{principal.principal.username}}<span class="caret" style="margin-left: 5px;"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <!-- 
          <li><a href="#/profile">Profile</a></li>
          -->
          <li><a href="<@spring.url '/auth/redirect' />">Home</a></li>
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