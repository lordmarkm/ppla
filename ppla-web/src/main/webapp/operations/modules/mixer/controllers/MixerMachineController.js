define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerMachineController', ['$scope', '$state', '$stateParams', 'mixers', 'WorkOrderService',
    function($scope, $state, $stateParams, mixers, WorkOrderService) {

    $scope.mixers = mixers;
    $scope.useMachine = function (machine) {
      $scope.commonData.machine = machine;
      $state.go('mixer.start.workorder');
    };

  }]);
});
