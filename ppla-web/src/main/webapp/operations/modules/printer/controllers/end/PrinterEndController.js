define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('PrinterEndController', ['$scope', '$state', 'process', 'PrintingProcessService',
    function($scope, $state, process, PrintingProcessService) {

    $scope.process = process;

    //Inject the operator as end actor
    if (!$scope.commonData.actor) {
      $state.go('printer.identity');
    }
    $scope.process.endActor = $scope.commonData.actor;


    $scope.confirmEnd = function () {
      delete $scope.process.type;
      PrintingProcessService.save({action: 'end'}, $scope.process, function (savedProcess) {
        alert('Printing Process completed.');
        $scope.process = savedProcess;
      });
    };

    $scope.processStatus = function () {
      if (!$scope.process.endActor) {
        return 'No end actor';
      } else if ($scope.process.dateCompleted) {
        return 'Completed';
      } else {
        return 'Complete';
      }
    };
  }]);
});
