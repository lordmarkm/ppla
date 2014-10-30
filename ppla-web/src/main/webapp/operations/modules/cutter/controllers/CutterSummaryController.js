define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterSummaryController', ['$scope', '$state', '$window', 'process',
    function($scope, $state, $window, process) {

    $scope.process = process;

    $scope.processStatus = function () {
      if ($scope.process.dateCompleted) {
        return 'Completed';
      } else {
        return 'Ongoing';
      }
    };

    $scope.close = function () {
      $window.close();
    };
  }]);
});
