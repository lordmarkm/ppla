define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('AuthController', ['$scope', 'AuthService',
    function($scope, AuthService) {

    $scope.principal = AuthService.get();

  }]);
});
