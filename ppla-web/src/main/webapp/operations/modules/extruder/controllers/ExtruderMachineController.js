define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ExtruderMachineController', ['$scope', '$state', '$stateParams', 'extruders', 'WorkOrderService',
    function($scope, $state, $stateParams, extruders, WorkOrderService) {

    $scope.extruders = extruders;
    $scope.useMachine = function (machine) {
      $scope.commonData.machine = machine;
      $state.go('extruder.start.workorder');
    };
    $scope.startStagedExtrusion = function (process) {
      //TODO
    }

  }]);
});