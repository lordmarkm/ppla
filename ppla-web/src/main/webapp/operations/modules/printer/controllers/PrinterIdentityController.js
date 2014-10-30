define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterIdentityController', ['$scope', '$state', '$filter', 'PplaUserService',
    function($scope, $state, $filter, PplaUserService) {

    $scope.status = 'Enter user code';
    $scope.tryGetOperator = function () {
      PplaUserService.get({code: $scope.userCode}, function (profile) {
        if (profile.id && profile.type === 'PRINTER') {
          $scope.commonData.actor = profile;
          $state.go('printer.scantag');
        } else if (profile.id) {
          $scope.status = 'User ' + $filter('name')(profile.name) + ' is not authorized to process Printing';
        }
      });
    };

  }]);
});
