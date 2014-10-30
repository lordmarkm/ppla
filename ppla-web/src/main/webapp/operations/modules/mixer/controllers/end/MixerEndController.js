define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerEndController', ['$scope', '$state', 'process', 'MixingProcessService',
    function($scope, $state, process, MixingProcessService) {

    $scope.process = process;

    //Inject the operator as end actor
    if (!$scope.commonData.actor) {
      $state.go('mixer.identity');
    }
    $scope.process.endActor = $scope.commonData.actor;


    $scope.confirmEnd = function () {
      delete $scope.process.type;
      MixingProcessService.save({action: 'end'}, $scope.process, function (savedProcess) {
        alert('Mixing Process completed.');
        $scope.process = savedProcess;
      });
    };

    $scope.processStatus = function () {
      if (!$scope.process.endActor) {
        return 'No end actor';
      } else if ($scope.process.materialsOut[0].quantity <= 0) {
        return 'None positive material output';
      } else if ($scope.process.stagingExtrusion) {
        return 'Staging Extrusion';
      } else if ($scope.process.dateCompleted) {
        return 'Completed';
      } else {
        return 'Complete';
      }
    };
  }]);
});
