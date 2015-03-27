define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterStartController', ['$scope', '$state', 'CuttingProcessService', 'WorkOrderService',
    function($scope, $state, CuttingProcessService, WorkOrderService) {

    //com.ppla.core.dto.process.CuttingProcessInfo
    $scope.process = {
      actor: $scope.commonData.actor,
      machine: $scope.commonData.machine,
      rollIn: $scope.commonData.rollIn
    };
    $scope.process.workOrder = WorkOrderService.get({trackingNo: $scope.commonData.workorderTrackingNo});

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
      case state_additional: return 'cutter.start.additional';
      default: return 'cutter.start.confirm';
      }
    };

    $scope.processStatus = function () {
//      if (!$scope.meta.additionalsSaved) {
//        return state_additional;
//      }
      return 'Complete';
    };

    $scope.saveProcess = function () {
      $scope.processing = true;
      CuttingProcessService.save({action: 'start'}, $scope.process, function(process) {
        alert('Process started');
        $scope.processing = false;
        $scope.process = {};
        resetMeta();
        $state.go('cutter.identity');
      });
    };
  }]);
});
