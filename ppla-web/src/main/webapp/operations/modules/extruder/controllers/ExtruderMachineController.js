define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ExtruderMachineController', ['$scope', '$state', '$stateParams', 'extruders', 'WorkOrderService',
    function($scope, $state, $stateParams, extruders, WorkOrderService) {

    $scope.extruders = extruders;

    //Assemble list of staged processes
    $scope.staged = [];
    var i = extruders.length;
    while (i--) {
      $scope.staged = $scope.staged.concat(extruders[i].staged);
    }

    $scope.useMachine = function (machine) {
      $scope.commonData.machine = machine;
      $state.go('extruder.start.workorder');
    };
    $scope.startStaged = function (process) {
      $scope.commonData.process = process;
      $scope.commonData.staged = true;
      $state.go('extruder.start.additional');
    };

  }]);
});
