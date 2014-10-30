define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerEndMaterialsController', ['$scope', '$state', 'material',
    function($scope, $state, material) {

    $scope.process.materialsOut = [{
      material: material[0],
      quantity: 0
    }];
    $scope.mixingOutputQuantity = 1;

    $scope.saveOutputQuantity = function (formValid) {
      if (!formValid) {
        return;
      }
      $scope.process.materialsOut[0].quantity = $scope.mixingOutputQuantity;
      $state.go('mixer.end.confirm');
    };

  }]);
});
