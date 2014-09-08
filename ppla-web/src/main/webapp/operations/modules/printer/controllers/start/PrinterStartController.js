define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterStartController', ['$scope', '$state', 'PrintingProcessService',
    function($scope, $state, PrintingProcessService) {

    //com.ppla.core.dto.process.PrintingProcessInfo
    $scope.process = {
      actor: $scope.commonData.actor,
      machine: $scope.commonData.machine,
      workOrder: $scope.commonData.workOrder
    };

    //for screens where there are no required fields
    $scope.meta = {
      additionalsSaved : false
    };
    function resetMeta () {
      for (var i in $scope.meta) {
        $scope.meta[i] = false;
      }
    }

    var 
      state_workorder = 'Work Order required',
      state_material = 'Materials required',
      state_additional = 'Additional details';

    $scope.nextState = function () {
      switch($scope.processStatus()) {
      case state_workorder: return 'extruder.start.workorder';
      case state_material: return 'extruder.start.materials';
      case state_additional: return 'extruder.start.additional';
      default: return 'extruder.start.confirm';
      }
    };

    $scope.processStatus = function () {
      if (!$scope.process.workOrder) {
        return state_workorder;
      }
      if (!$scope.process.materialsIn || $scope.process.materialsIn.length < 1) {
        return state_material;
      }
      if (!$scope.meta.additionalsSaved) {
        return state_additional;
      }
      return 'Complete';
    };

    $scope.saveProcess = function () {
      ExtrusionProcessService.save({action: 'start'}, $scope.process, function(process) {
        alert('Process started');
        $scope.process = {};
        resetMeta();
        $state.go('extruder.identity');
      });
    };
  }]);
});
