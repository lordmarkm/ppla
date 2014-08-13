define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseAdditionalController', ['$scope', '$state',
    function($scope, $state) {

    $scope.name = 'MixerAdditionalController';
    $scope.additionalInfo = {
        dateStarted: new Date()
    };

    $scope.setAdditionalDetails = function () {
      $scope.process.dateStarted = $scope.additionalInfo.dateStarted;
      $state.go($scope.nextState());
    };
  }]);
});
