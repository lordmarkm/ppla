define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterStartController', ['$scope', '$state', 'PrintingProcessService', 'WorkOrderService',
    function($scope, $state, PrintingProcessService, WorkOrderService) {

    //com.ppla.core.dto.process.PrintingProcessInfo
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
      case state_additional: return 'printer.start.additional';
      default: return 'printer.start.confirm';
      }
    };

    $scope.processStatus = function () {
      if (!$scope.meta.additionalsSaved) {
        return state_additional;
      }
      return 'Complete';
    };

    $scope.saveProcess = function () {
      $scope.processing = true;
      PrintingProcessService.save({action: 'start'}, $scope.process, function(process) {
        $scope.processing = false;
        alert('Process started');
        $scope.process = {};
        resetMeta();
        $state.go('printer.identity');
      });
    };
  }]);
});
