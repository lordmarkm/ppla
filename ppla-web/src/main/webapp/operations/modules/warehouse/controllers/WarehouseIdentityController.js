define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseIdentityController', ['$scope', '$state', '$filter', 'PplaUserService',
    function($scope, $state, $filter, PplaUserService) {

    $scope.status = 'Enter user code';
    $scope.tryGetOperator = function () {
      PplaUserService.get({code: $scope.userCode}, function (profile) {
        if (profile.id && profile.type === 'WAREHOUSE') {
          $scope.process.actor = profile;
          $state.go($scope.nextState());
        } else if (profile.id) {
          $scope.status = 'User ' + $filter('name')(profile.name) + ' is not authorized to withdraw from the Warehouse';
        }
      });
    };

  }]);
});
