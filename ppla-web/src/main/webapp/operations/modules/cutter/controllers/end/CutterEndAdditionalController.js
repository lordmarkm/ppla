define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterEndAdditionalController', ['$scope', '$state',
    function($scope, $state) {

    $scope.additionalInfo = {};

    $scope.saveAdditionalDetails = function () {
      $scope.process.remarks = $scope.additionalInfo.remarks;
      $scope.meta.additionalsSaved = true;
      $state.go('cutter.end.confirm');
    };
  }]);
});
