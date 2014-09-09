define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterScantagController', ['$scope', '$state', 'ProcessMaterialStackService', 'PrintingProcessService',
    function($scope, $state, ProcessMaterialStackService, PrintingProcessService) {

    $scope.tryGetRoll = function () {
      ProcessMaterialStackService.get({tag: $scope.rollCode}, function (roll) {
        if (roll.workorderTrackingNo) {
          $scope.commonData.rollIn = roll;
          $scope.commonData.workorderTrackingNo = roll.workorderTrackingNo;

          PrintingProcessService.get({action: 'rollTag', id: roll.tag}, function (process) {
            if (process.id) {
              //If roll is currently being used in a process, proceed to end flow
              $scope.commonData.process = process;
              $state.go('printer.end.confirm', {processId: process.id});
            } else {
              //Else go to machine selection screen
              $state.go('printer.machine');
            }
          });
        }
      });
    };

  }]);
});
