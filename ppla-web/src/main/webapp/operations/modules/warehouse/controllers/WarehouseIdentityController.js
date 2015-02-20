define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseIdentityController', ['$scope', '$state', '$filter', 'PplaUserService',
    function($scope, $state, $filter, PplaUserService) {

    $scope.status = 'Enter user code';
    $scope.tryGetOperator = function () {
      PplaUserService.get({code: $scope.userCode}, function (profile) {
        if (profile.id) {
          $scope.process.actor = profile;
          $state.go($scope.nextState());
        }
      });
    };

  }]);
});
