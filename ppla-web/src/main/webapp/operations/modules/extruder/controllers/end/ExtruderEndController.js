define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ExtruderEndController', ['$scope', '$state', '$window', 'process', 'ExtrusionProcessService',
    function($scope, $state, $window, process, ExtrusionProcessService) {

    var print_url = '/extrusion/printtag/';
    $scope.process = process;

    //Inject the operator as end actor
    if (!$scope.commonData.actor) {
      $state.go('extruder.identity');
    }
    $scope.process.endActor = $scope.commonData.actor;


    $scope.confirmEnd = function () {
      delete $scope.process.type;
      ExtrusionProcessService.save({action: 'end'}, $scope.process, function (savedProcess) {
        alert('Extrusion Process completed.');
        $scope.process = savedProcess;
      });
    };

    $scope.processStatus = function () {
      if (!$scope.process.endActor) {
        return 'No end actor';
      } else if (!$scope.process.materialsOut.length) {
        return 'None positive material output';
      } else if ($scope.process.dateCompleted) {
        return 'Completed';
      } else {
        return 'Complete';
      }
    };

    $scope.printTags = function () {
      if ($scope.process.materialsOut.length) {
        console.debug('Printing tag.');
        $window.open(print_url + $scope.process.materialsOut[0].tag);
      }
    };
  }]);
});
