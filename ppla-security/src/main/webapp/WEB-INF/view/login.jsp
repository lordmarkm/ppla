<html>
<head>
  <link rel="stylesheet" href="/lib/bootstrap-3.0.3/css/bootstrap.min.css">
</head>

<body>
  <div class="container">
    <div class="col-sm-12">
      <div class="col-sm-6 col-md-offset-3" style="margin-top: 100px;">
        <div class="panel panel-primary">
          <div class="text-center panel-heading">
            <div class="panel-title"><strong>PPLA Films</strong> Manufacturing Execution Software</div>
          </div>
          <div class="panel-body">
            <#if msg??><div class="alert alert-info text-center">${msg }</div></#if>
            <form action="/login/authenticate" method="post" class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-4 control-label">Username</label>
                <div class="col-sm-8">
                  <input type="text" name="username" class="form-control" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">Password</label>
                <div class="col-sm-8">
                  <input type="password" name="password" class="form-control" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">Remember me</label>
                <div class="col-sm-8">
                  <div class="checkbox"><input type='checkbox' name='remember-me' /></div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-8">
                  <input type="submit" value="Login" class="form-control"/>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
</html>