define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerMaterialsController', ['$scope', '$state', 'MaterialService',
    function($scope, $state, MaterialService) {

    //materials[?] = MaterialBalanceStackInfo
    //materialIn = RawMaterialStackInfo

    $scope.toAdd = {
        quantity: 0,
        materialIn: undefined
    };
    $scope.materialsIn = [];
    //Can't actually add materials if workorder doesn't exist
    if ($scope.process.workOrderTrackingNo) {
      $scope.materials = MaterialService.query({type: $scope.process.workOrderTrackingNo}, function (mats) {
        for (var i = 0, len = mats.length; i < len; ++i) {
          if (mats[i].source === 'RAW') {
            $scope.toAdd.materialIn = mats[i];
            break;
          }
        }
      });
    }

    function findAdded(selected) {
      var added;
      for (var i = 0, len = $scope.materialsIn.length; i < len; ++i) {
        added = $scope.materialsIn[i];
        //if material has already been added, max amt = initial amt - added amt
        if (added.material.id === selected.material.id) {
          return added;
        }
      }
      return null;
    }

    $scope.max = function (selected) {
      var added, retVal;
      added = findAdded(selected);
      if (added) {
        retVal = selected.quantityRemaining - added.quantity;
      } else {
        retVal = selected.quantityRemaining;
      }
      //console.debug('Returning: ' + retVal);
      return parseFloat(retVal);
    };

    $scope.namePlusMax = function (stack) {
      return stack.material.name + ' (' + $scope.max(stack) + ')';
    };

    $scope.addMaterialIn = function () {
      var added = findAdded($scope.toAdd.materialIn);
      if (!parseFloat($scope.toAdd.quantity) || $scope.toAdd.quantity > $scope.max($scope.toAdd.materialIn)) {
        alert('No!');
        return;
      }
      if (added) {
        added.quantity += $scope.toAdd.quantity;
      } else {
        $scope.materialsIn.push({
          material: $scope.toAdd.materialIn.material,
          quantity: $scope.toAdd.quantity
        });
      }
    };

    $scope.remove = function (stack) {
      var added;
      for (var i = 0, len = $scope.materialsIn.length; i < len; ++i) {
        added = $scope.materialsIn[i];
        //if material has already been added, max amt = initial amt - added amt
        if (added.material.id === stack.material.id) {
          $scope.materialsIn.splice(i, 1);
        }
      }
    };

    $scope.setMaterials = function () {
      $scope.process.materialsIn = angular.copy($scope.materialsIn);
      $state.go('mixer.additional');
    };
  }]);
});
