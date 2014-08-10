define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerAdditionalController', ['$scope',
    function($scope) {

    $scope.name = 'MixerAdditionalController';
    $scope.additionalInfo = {
        startDateTime: new Date()
    };

    $scope.getOperator = function () {
      
    };

    $scope.setAdditionalDetails = function () {
      
    };
  }]);
});
