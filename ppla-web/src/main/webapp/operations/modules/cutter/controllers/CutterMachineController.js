define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterMachineController', ['$scope', '$state', '$stateParams', 'cutters', 'WorkOrderService',
    function($scope, $state, $stateParams, cutters, WorkOrderService) {

    $scope.cutters = cutters;
    $scope.useMachine = function (machine) {
      $scope.commonData.machine = machine;
      $state.go('cutter.start.additional');
    };

  }]);
});
