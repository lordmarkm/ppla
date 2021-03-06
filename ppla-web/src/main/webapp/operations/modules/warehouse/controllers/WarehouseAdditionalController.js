define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WarehouseAdditionalController', ['$scope', '$state',
    function($scope, $state) {

    $scope.name = 'MixerAdditionalController';
    $scope.additionalInfo = {
        dateStarted: new Date()
    };

    $scope.setAdditionalDetails = function () {
      $scope.process.dateStarted = $scope.additionalInfo.dateStarted;
      $scope.process.remarks = $scope.additionalInfo.remarks;
      $state.go($scope.nextState());
    };
  }]);
});
