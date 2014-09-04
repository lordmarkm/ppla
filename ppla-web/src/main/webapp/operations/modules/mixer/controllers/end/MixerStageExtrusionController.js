define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerStageExtrusionController', ['$scope', '$state', 'extruders', 'ExtrusionProcessService',
    function($scope, $state, extruders, ExtrusionProcessService) {

    $scope.extrusions = {};
    $scope.extruders = extruders;
    $scope.process.stagingExtrusion = true;

    $scope.stageExtrusionProcess = function (extruder) {
      var stagedProcess = {
        workOrder: $scope.process.workOrders[0],
        actor: $scope.process.endActor,
        machine: extruder,
        materialsIn: [{
          material: $scope.process.materialsIn[0].material,
          quantity: 0
        }]
      };
      $scope.extrusions[extruder.code] = stagedProcess;
    };

    $scope.stageExtrusions = function (valid) {
      if (!valid) {
        console.debug('Staging failed, some input is invalid.');
        return;
      }

      var extrusion, stagedExtrusionCount = 0;
      for (var i in $scope.extrusions) {
        extrusion = $scope.extrusions[i];
        if (extrusion.id) {
          continue;
        }
        ExtrusionProcessService.save({action: 'stage'}, $scope.extrusions[i], function (response) {
          $scope.extrusions[i].id = response.id;
        });
        stagedExtrusionCount++;
      }
      if (stagedExtrusionCount > 0) {
        alert(stagedExtrusionCount + ' extrusion processes staged.');
      } else {
        alert('No processes for staging.');
      }
    }
  }]);
});
