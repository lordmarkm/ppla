define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerMachineController', ['$scope', '$stateParams', 'MachineService', 'WorkOrderService',
    function($scope, $stateParams, MachineService, WorkOrderService) {

    $scope.machines = MachineService.query({type:'MIXING'});
    $scope.process.workOrderTrackingNo = $stateParams.trackingNo;

  }]);
});
