define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ExtruderEndMaterialsController', ['$scope', '$state', 'materials',
    function($scope, $state, materials) {

    //Set materials to scope from resolve
    $scope.materials = materials;
    $scope.propertyHolder = {
        qty : 1
    };

    //Initialize 'draft' materials holder
    $scope.toAdd = [];

    //Set select defaults if materials exist
    if (materials.length) {
      $scope.material = materials[0];
    }

    //Add material to draft
    $scope.add = function (formValid) {
      $scope.toAdd.push({material: $scope.material, quantity: $scope.propertyHolder.qty, tracker: generateTracker()});
    };

    //Generate element tracker (used for removing material from draft)
    function generateTracker() {
      return (Math.random() + 1).toString(36).substring(7);
    }

    //Remove material added to draft
    $scope.remove = function (matStack) {
      var i = $scope.toAdd.length;
      while (i--) {
        if ($scope.toAdd[i].tracker === matStack.tracker) {
          $scope.toAdd.splice(i, 1);
          break;
        }
      }
    };

    //angular find added material
    $scope.findAdded = function (material) {
      var i = $scope.toAdd.length;
      while (i--) {
        if ($scope.toAdd[i].tracker === material.material.tracker) {
          return $scope.toAdd[i];
        }
      }
    };

    $scope.save = function (formValid) {
      if (!formValid) {
        return;
      }
      $scope.process.materialsOut = $scope.toAdd;
      $state.go('extruder.end.confirm');
    };

  }]);
});
