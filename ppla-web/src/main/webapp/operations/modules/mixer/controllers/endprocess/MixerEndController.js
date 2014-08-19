define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerEndController', ['$scope', '$state', 'process',
    function($scope, $state, process) {

    console.debug('Process injected. process=' + JSON.stringify(process));
    $scope.process = process;
  }]);
});
