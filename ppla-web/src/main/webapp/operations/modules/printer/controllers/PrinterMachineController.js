define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterMachineController', ['$scope', '$state', '$stateParams', 'printers', 'WorkOrderService',
    function($scope, $state, $stateParams, printers, WorkOrderService) {

    $scope.printers = printers;
    $scope.useMachine = function (machine) {
      $scope.commonData.machine = machine;
      $state.go('printer.start.additional');
    };

  }]);
});
