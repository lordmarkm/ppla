define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseIdentityController', ['$scope', '$state', 'PplaUserService',
    function($scope, $state, PplaUserService) {

    $scope.tryGetOperator = function () {
      PplaUserService.get({code: $scope.userCode}, function (profile) {
        if (profile.username) {
          $scope.process.actor = profile;
          $state.go($scope.nextState());
        }
      });
    };

  }]);
});
