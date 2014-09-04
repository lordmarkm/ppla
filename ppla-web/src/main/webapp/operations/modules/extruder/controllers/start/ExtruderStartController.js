define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ExtruderStartController', ['$scope', '$state', 'process', 'ExtrusionProcessService',
    function($scope, $state, process, ExtrusionProcessService) {

    //com.ppla.core.dto.process.ExtrusionProcessInfo
    $scope.process = process || {
      actor: $scope.commonData.actor,
      machine: $scope.commonData.machine
    };

    var 
      state_workorder = 'Work Order required',
      state_material = 'Materials required';

    $scope.nextState = function () {
      switch($scope.processStatus()) {
      case state_workorder: return 'extruder.start.workorder';
      case state_material: return 'extruder.start.materials';
      default: return 'extruder.start.confirm';
      }
    };

    $scope.processStatus = function () {
      if (!$scope.process.workOrders || $scope.process.workOrders.length < 1) {
        return state_workorder;
      }
      if (!$scope.process.materialsIn || $scope.process.materialsIn.length < 1) {
        return state_material;
      }
      return 'Complete';
    };

    $scope.saveProcess = function () {
      MixingProcessService.save($scope.process, function(process) {
        console.debug('Got save response: ' + JSON.stringify(process));
        alert('Process created');
        $scope.process = {};
        $state.go('extruder.identity');
      });
    };
  }]);
});
