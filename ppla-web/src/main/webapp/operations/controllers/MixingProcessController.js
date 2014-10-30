define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixingProcessController', ['$state', '$scope', '$stateParams', 'MaterialService', 'MachineService', 'MixingProcessService',
    function($state, $scope, $stateParams, MaterialService, MachineService, MixingProcessService) {

    $scope.params = $state.params;
    $scope.trackingNo = $stateParams.trackingNo;
    $scope.dirty = false;
    $scope.process = {
        workOrderTrackingNo : $scope.trackingNo,
        materialsIn : [],
        materialsOut: []
    };
    $scope.materials = MaterialService.query({type: $scope.trackingNo}, function (mats) {
      if ($scope.params.initMat) {
        for (var i = 0, len = $scope.materials.length; i < len; ++i) {
          var materialBalanceStack = $scope.materials[i];
          if (materialBalanceStack.material.id === parseInt($scope.params.initMat)) {
            $scope.materialIn = materialBalanceStack.material;
            $scope.quantityIn = materialBalanceStack.quantityRemaining;
          }
        }
      }
    });
    $scope.machines = MachineService.query({type:'MIXING'});

    $scope.addMaterialIn = function () {
      
    };
  }]);
});
