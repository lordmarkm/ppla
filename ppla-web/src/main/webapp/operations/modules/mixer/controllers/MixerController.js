define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerController', ['$scope', 'MixingProcessService',
    function($scope, MixingProcessService) {

    //com.ppla.core.dto.process.MixingProcessInfo
    $scope.process = {};

    //for screens where there are no required fields
    $scope.meta = {
      additionalsSaved : false
    };
    function resetMeta () {
      for (var i in $scope.meta) {
        $scope.meta[i] = false;
      }
    }

    var state_actor = 'Process Actor required',
      state_machine = 'Machine required',
      state_workorder = 'Work Order required',
      state_material = 'Materials required',
      state_additional = 'Additional details';

    $scope.nextState = function () {
      switch($scope.processStatus()) {
      case state_actor: return 'mixer.identity';
      case state_machine: return 'mixer.machine';
      case state_workorder: return 'mixer.workorder';
      case state_material: return 'mixer.materials';
      case state_additional: return 'mixer.additional';
      default: return 'mixer.confirm';
      }
    };

    $scope.processStatus = function () {
      if (!$scope.process.actor || !$scope.process.actor.id) {
        return state_actor;
      }
      if (!$scope.process.machine || !$scope.process.machine.id) {
        return state_machine;
      }
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
        $state.go($scope.nextState());
      });
    };
  }]);
});
