define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterScantagController', ['$scope', '$state', 'ProcessMaterialStackService', 'CuttingProcessService',
    function($scope, $state, ProcessMaterialStackService, CuttingProcessService) {

    $scope.tryGetRoll = function () {
      ProcessMaterialStackService.get({tag: $scope.rollCode}, function (roll) {
        if (roll.workorderTrackingNo) {
          $scope.commonData.rollIn = roll;
          $scope.commonData.workorderTrackingNo = roll.workorderTrackingNo;

          CuttingProcessService.get({action: 'rollTag', id: roll.tag}, function (process) {
            if (process.id) {
              //If roll is currently being used in a process, proceed to end flow
              $scope.commonData.process = process;
              $state.go('cutter.end.materials', {processId: process.id});
            } else {
              //Else go to machine selection screen
              $state.go('cutter.machine');
            }
          });
        }
      });
    };

  }]);
});
