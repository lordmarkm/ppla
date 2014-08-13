define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseMaterialsController', ['$scope', '$state', 'MaterialService',
    function($scope, $state, MaterialService) {

    //materials[?] = RawMaterialInfo
    //materialIn = RawMaterialStackInfo

    $scope.toAdd = {
        quantity: 0,
        material: undefined
    };
    $scope.materialsToWithdraw = [];

    //Get material inventory, $scope.materials = List<RawMaterialInfo>
    MaterialService.get(function (inventory) {
      $scope.materials = inventory.rawMaterials;
      if ($scope.materials.length) {
        $scope.toAdd.material = $scope.materials[0];
      }
    });

    function findAdded(selected) {
      var added, i = $scope.materialsToWithdraw.length;
      while (i--) {
        added = $scope.materialsToWithdraw[i];
        if (added.material.id === selected.id) {
          return added;
        }
      }
      return null;
    }

    $scope.addMaterialIn = function () {
      var added = findAdded($scope.toAdd.material);
      if (added) {
        added.quantity += $scope.toAdd.quantity;
      } else {
        $scope.materialsToWithdraw.push({
          material: $scope.toAdd.material,
          quantity: $scope.toAdd.quantity
        });
      }
    };

    $scope.remove = function (stack) {
      var added, i = $scope.materialsToWithdraw.length;
      while (i--) {
        added = $scope.materialsToWithdraw[i];
        if (added.material.id === stack.material.id) {
          $scope.materialsToWithdraw.splice(i, 1);
        }
      }
    };

    $scope.setMaterials = function () {
      $scope.process.materialStacks = angular.copy($scope.materialsToWithdraw);
      $state.go($scope.nextState());
    };
  }]);
});
