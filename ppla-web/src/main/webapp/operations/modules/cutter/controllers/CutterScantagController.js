define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterScantagController', ['$scope', '$state', 'ProcessMaterialStackService', 'CuttingProcessService',
    function($scope, $state, ProcessMaterialStackService, CuttingProcessService) {

    $scope.tryGetRoll = function () {
      ProcessMaterialStackService.get({tag: $scope.rollCode}, function (roll) {
        if (roll.workorderTrackingNo) {
          $scope.commonData.rollIn = roll;
          $scope.commonData.workorderTrackingNo = roll.workorderTrackingNo;

          CuttingProcessService.get({action: 'rollTag', id: roll.tag}, function (process) {
            if (process.dateCompleted) {
              //If cutting has already been completed for this tag, show confirm page again
              $scope.commonData.process = process;
              $state.go('cutter.end.confirm', {processId: process.id});
            } else if (process.id) {
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
