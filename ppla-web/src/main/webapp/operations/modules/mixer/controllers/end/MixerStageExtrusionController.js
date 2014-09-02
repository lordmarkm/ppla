define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerStageExtrusionController', ['$scope', '$state', 'extruders',
    function($scope, $state, extruders) {

    $scope.extrusions = {};
    $scope.extruders = extruders;

    $scope.stageExtrusionProcess = function (extruder) {
      var stagedProcess = {
        actor: $scope.process.endActor,
        machine: extruder
      };
      $scope.extrusions[extruder.code] = stagedProcess;
    };

  }]);
});
