angular.module('ppla.controllers')

.controller('UserManagementController', function($scope, $state, ngTableParams, PplaUserService) {

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

  $scope.createNew = function () {
    $scope.user = {type: 'OPERATOR'};
    $state.go('users.edit');
  };

  $scope.editUser = function (user) {
    $scope.user = user;
    $state.go('users.edit');
  };
  
  $scope.saveUser = function () {
    PplaUserService.save({action: 'operator'}, $scope.user, function (response) {
      $scope.tableParams.reload();
      $state.go('users.list');
    });
  };
});