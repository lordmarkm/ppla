angular.module('ppla.controllers')

.controller('AuthController', function($scope, AuthService, PplaUserService) {
  $scope.principal = AuthService.get(function(principal) {
    if (principal.authenticated) {
      $scope.profile = PplaUserService.get({username: principal.principal.username}, function () {
        console.debug('Got profile: ' + JSON.stringify($scope.profile));
      });
    }
  });
});