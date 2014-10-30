define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ExtruderIdentityController', ['$scope', '$state', '$filter', 'PplaUserService',
    function($scope, $state, $filter, PplaUserService) {

    $scope.status = 'Enter user code';
    $scope.tryGetOperator = function () {
      PplaUserService.get({code: $scope.userCode}, function (profile) {
        if (profile.id && profile.type === 'EXTRUDER') {
          $scope.commonData.actor = profile;
          $state.go('extruder.machine');
        } else if (profile.id) {
          $scope.status = 'User ' + $filter('name')(profile.name) + ' is not authorized to process Extrusion';
        }
      });
    };

  }]);
});
