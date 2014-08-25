define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerEndController', ['$scope', '$state', 'process', 'material',
    function($scope, $state, process, material) {

    $scope.process = process;
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
      $state.go('mixerend.stageextrusion');
    };
  }]);
});
