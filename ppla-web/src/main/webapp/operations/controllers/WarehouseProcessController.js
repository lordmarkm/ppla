define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseProcessController', ['$state', '$scope', '$stateParams', 'MaterialService', 'WarehouseProcessService',
    function($state, $scope, $stateParams, MaterialService, WarehouseProcessService) {

    $scope.trackingNo = $stateParams.trackingNo;
    $scope.dirty = false;
    $scope.process = {
        workOrderTrackingNo : $scope.trackingNo,
        materialStacks : []
    };

    MaterialService.get(function (inventory) {
      $scope.materials = inventory.rawMaterials;
    });

    $scope.addMaterial = function () {
      if (!$scope.rawMaterialForm.$valid) {
        return;
      }
      //increment if already added
      var matStack;
      for (var i = 0, len = $scope.process.materialStacks.length; i < len; ++i) {
        matStack = $scope.process.materialStacks[i];
        if (matStack.material.id === $scope.material.id) {
          matStack.quantity += $scope.quantity;
          return;
        }
      }
      //add if new
      $scope.process.materialStacks.push({
        material: $scope.material,
        quantity: $scope.quantity
      });
      $scope.dirty = true;
    };

    $scope.saveProcess = function () {
      WarehouseProcessService.save($scope.process, function(process) {
        $scope.process = process;
        $state.go('workorder', {trackingNo: $scope.trackingNo});
      });
    };
  }]);
});
