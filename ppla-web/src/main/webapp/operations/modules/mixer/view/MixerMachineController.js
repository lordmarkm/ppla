define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerMachineController', ['$scope', '$state', '$stateParams', 'MachineService', 'WorkOrderService',
    function($scope, $state, $stateParams, MachineService, WorkOrderService) {

    $scope.machines = MachineService.query({type:'MIXING'});
    $scope.process.workOrderTrackingNo = $stateParams.trackingNo;

    $scope.useMachine = function (machine) {
      $scope.process.machine = machine;
      $state.go('mixer.materials');
    };
  }]);
});
