define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerAdditionalController', ['$scope', '$state',
    function($scope, $state) {

    $scope.name = 'MixerAdditionalController';
    $scope.additionalInfo = {
        startDateTime: new Date()
    };

    $scope.saveAdditionalDetails = function () {
      $scope.process.remarks = $scope.additionalInfo.remarks;
      $scope.meta.additionalsSaved = true;
      $state.go($scope.nextState());
    };
  }]);
});
