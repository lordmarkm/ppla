define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerStageExtrusionController', ['$scope', '$state', 'machines',
    function($scope, $state, machines) {

    $scope.machines = machines;

  }]);
});
