define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerIdentityController', ['$scope', '$state', 'PplaUserService',
    function($scope, $state, PplaUserService) {

    $scope.tryGetOperator = function () {
      PplaUserService.get({code: $scope.userCode}, function (profile) {
        if (profile.username) {
          $scope.commonData.actor = profile;
          $state.go('mixer.machine');
        }
      });
    };

  }]);
});
