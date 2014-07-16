<html>

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

<script data-main="/operations/main.js" src="/lib/require/require.js"></script>

<body>

  <!-- NAVIGATION -->
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
      <a class="navbar-brand" ui-sref="#">PPLA Films Manufacturing Execution Software</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a ui-sref="workorders">Work Orders</a></li>  
    </ul>
  </nav>

  <!-- Main Content -->
  <div class="container">
    <div ui-view></div>
  </div>

  <div style="margin-bottom: 30px;"></div>
</body>

</html>