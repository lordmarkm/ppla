angular.module('ppla.controllers')

.controller('UserManagementController', function($scope, $state, ngTableParams, PplaUserService) {

  $scope.user = {type: 'OPERATOR'};

  $scope.tableParams = new ngTableParams({
    page: 1,
    count: 5,
    sorting: {
      id: 'asc'
    }
  }, {
    total: 0,
    counts: [5,10,25,50,100], //determines pager
    getData: function($defer, params) {
      //Ajax request to backend resource
      PplaUserService.page(params.$params, function(response) {
        params.total(response.total);
        $defer.resolve(response.data);
      });
    }
  });

  function reloadTable() {
    $scope.tableParams.page(1);
  }

  $scope.createNew = function () {
    $scope.user = {type: 'OPERATOR'};
    $state.go('users.edit');
  };

  $scope.editUser = function (user) {
    $scope.user = user;
    $state.go('users.edit');
  };
  
  $scope.deleteUser = function (user) {
    if(!confirm('This will permanently delete this user.')) {
      return false;
    }
    PplaUserService.remove({code: user.code}, function () {
      reloadTable();
    });
  };

  $scope.saveUser = function () {
    console.debug('Trying to save user. user=' + JSON.stringify($scope.user));
    PplaUserService.save({action: 'operator'}, $scope.user, function (response) {
      $scope.tableParams.reload();
      $state.go('users.list');
    }, function (e) {
      alert("Error saving user. Please check that username and code are unique.");
    });
  };
});