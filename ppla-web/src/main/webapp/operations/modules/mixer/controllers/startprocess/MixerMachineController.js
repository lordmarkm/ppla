define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerMachineController', ['$scope', '$state', '$stateParams', 'MachineService', 'WorkOrderService',
    function($scope, $state, $stateParams, MachineService, WorkOrderService) {

    $scope.machines = MachineService.query({type:'MIXING'});

    $scope.useMachine = function (machine) {
      $scope.process.machine = machine;
      $state.go($scope.nextState());
    };
  }]);
});
