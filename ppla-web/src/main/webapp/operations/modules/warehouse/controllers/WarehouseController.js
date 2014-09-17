define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseController', ['$scope', '$state', 'WarehouseProcessService',
    function($scope, $state, WarehouseProcessService) {

    $scope.process = {};

    var state_workorder = 'Work Order required',
        state_actor = 'Process Actor required',
        state_material = 'Materials required',
        state_startdate = 'Start date required';

    $scope.nextState = function () {
      switch($scope.processStatus()) {
      case state_workorder: return 'warehouse.workorder';
      case state_actor: return 'warehouse.identity';
      case state_material: return 'warehouse.materials';
      case state_startdate: return 'warehouse.additional';
      default: return 'warehouse.confirm';
      }
    };

    $scope.processStatus = function () {
      if (!$scope.process.actor || !$scope.process.actor.id) {
        return state_actor;
      }
      if (!$scope.process.workOrder || !$scope.process.workOrder.trackingNo) {
        return state_workorder;
      }
      if (!$scope.process.materialStacks || $scope.process.materialStacks.length < 1) {
        return state_material;
      }
      if (!$scope.process.dateStarted) {
        return state_startdate;
      }
      return 'Complete';
    };

    $scope.saveProcess = function () {
      WarehouseProcessService.save($scope.process, function(process) {
        alert('Process created');
        $scope.process = {};
        $state.go($scope.nextState());
      });
    };
  }]);
});
