angular.module('ppla.controllers')

.controller('AuthController', function($scope, AuthService) {
  $scope.principal = AuthService.get();
});