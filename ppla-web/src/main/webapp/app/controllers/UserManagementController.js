angular.module('ppla.controllers')

.controller('UserManagementController', function($scope, PplaUserService) {

  $scope.users = PplaUserService.query();

});