define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseProcessController', ['$scope', '$stateParams', 'MaterialService',
    function($scope, $stateParams, MaterialService) {

    $scope.process = {
        materialStacks : []
    };
    $scope.trackingNo = $stateParams.trackingNo;
    $scope.dirty = false;

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
  }]);
});
