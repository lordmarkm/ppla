define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('AuthController', ['$scope', 'AuthService', 'PplaUserService',
    function($scope, AuthService, PplaUserService) {

    $scope.principal = AuthService.get(function(principal) {
      if (principal.authenticated) {
        $scope.profile = PplaUserService.get({username: principal.principal.username}, function () {
          console.debug('Got profile: ' + JSON.stringify($scope.profile));
        });
      }
    });

  }]);
});
