define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ExtruderPrintableController', ['$scope', '$state', 'process',
    function($scope, $state, process) {

    $scope.process = process;

  }]);
});
