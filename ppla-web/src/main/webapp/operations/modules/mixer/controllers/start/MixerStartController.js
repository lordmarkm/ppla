define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerStartController', ['$scope', '$state', 'MixingProcessService',
    function($scope, $state, MixingProcessService) {

    //com.ppla.core.dto.process.MixingProcessInfo
    $scope.process = {
      actor: $scope.commonData.actor,
      machine: $scope.commonData.machine
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

    var state_workorder = 'Work Order required',
      state_material = 'Materials required',
      state_additional = 'Additional details';

    $scope.nextState = function () {
      switch($scope.processStatus()) {
      case state_workorder: return 'mixer.start.workorder';
      case state_material: return 'mixer.start.materials';
      case state_additional: return 'mixer.start.additional';
      default: return 'mixer.start.confirm';
      }
    };

    $scope.processStatus = function () {
      if (!$scope.process.workOrders || $scope.process.workOrders.length < 1) {
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
      MixingProcessService.save($scope.process, function(process) {
        console.debug('Got save response: ' + JSON.stringify(process));
        alert('Process created');
        $scope.process = {};
        resetMeta();
        $state.go('mixer.identity');
      });
    };
  }]);
});
