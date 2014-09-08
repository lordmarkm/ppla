define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterScantagController', ['$scope', '$state', '$stateParams', 'TagService',
    function($scope, $state, $stateParams, TagService) {

    $scope.scanTag = function (tag) {
      $scope.commonData.machine = machine;
      $state.go('printer.start.workorder');
    };

  }]);
});
