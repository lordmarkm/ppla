define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterEndMaterialsController', ['$scope', '$state',
    function($scope, $state) {

    //Set default # of output products produced
    $scope.quantity = 1;

    $scope.save = function (formValid) {
      if (!formValid) {
        return;
      }
      $scope.process.productOut = $scope.quantity;
      $state.go('cutter.end.confirm');
    };

  }]);
});
