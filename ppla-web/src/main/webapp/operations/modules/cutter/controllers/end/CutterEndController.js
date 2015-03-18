define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('CutterEndController', ['$scope', '$state', 'process', 'CuttingProcessService',
    function($scope, $state, process, CuttingProcessService) {

    $scope.process = process;

    //Inject the operator as end actor
    if (!$scope.commonData.actor) {
      $state.go('cutter.identity');
    }
    $scope.process.endActor = $scope.commonData.actor;

    //for screens where there are no required fields
    $scope.meta = {
      additionalsSaved : false
    };

    $scope.confirmEnd = function () {
      delete $scope.process.type;
      CuttingProcessService.save({action: 'end'}, $scope.process, function (savedProcess) {
        alert('Cutting Process completed.');
        $scope.process = savedProcess;
      });
    };

    $scope.processStatus = function () {
      if (!$scope.process.endActor) {
        return 'No end actor';
      } else if ($scope.process.paused) {
        return 'Paused';
      } else if (!$scope.process.productOut) {
        return 'Product output required';
      } else if (!$scope.meta.additionalsSaved) {
        return 'Remarks';
      } else if ($scope.process.dateCompleted) {
        return 'Completed';
      } else {
        return 'Complete';
      }
    };

    $scope.pause = function () {
      CuttingProcessService.save({action: 'pause'}, $scope.process, function () {
        alert('Process has been paused.');
        $state.go('cutter.identity');
      });
    };
    $scope.resume = function () {
      CuttingProcessService.save({action: 'resume'}, $scope.process, function () {
        alert('Process has been resumed.');
        $state.go('cutter.identity');
      });
    };
  }]);
});
