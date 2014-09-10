define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterAdditionalController', ['$scope', '$state',
    function($scope, $state) {

    $scope.additionalInfo = {};

    $scope.saveAdditionalDetails = function () {
      $scope.process.remarks = $scope.additionalInfo.remarks;
      $scope.meta.additionalsSaved = true;
      $state.go($scope.nextState());
    };
  }]);
});
