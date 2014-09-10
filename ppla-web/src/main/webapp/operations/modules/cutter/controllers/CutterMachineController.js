define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterMachineController', ['$scope', '$state', '$stateParams', 'cutters', 'WorkOrderService',
    function($scope, $state, $stateParams, cutters, WorkOrderService) {

    $scope.printers = printers;
    $scope.useMachine = function (machine) {
      $scope.commonData.machine = machine;
      $state.go('cutter.start.additional');
    };

  }]);
});
