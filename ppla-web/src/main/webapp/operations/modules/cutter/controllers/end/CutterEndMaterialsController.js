define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterEndMaterialsController', ['$scope', '$state', 'CuttingProcessService',
    function($scope, $state, CuttingProcessService) {

    //Set default # of output products produced
    $scope.quantity = 1;

    $scope.save = function (formValid) {
      if (!formValid) {
        return;
      }
      $scope.process.productOut = $scope.quantity;
      $state.go('cutter.end.additional');
    };

  }]);
});
