angular.module('ppla.controllers')

.controller('UserManagementController', function($scope, $state, PplaUserService) {

  function init() {
    $scope.users = PplaUserService.query({type: 'OPERATOR'});
  }
  init();

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
      init();
      $state.go('users.list');
    });
  };
});