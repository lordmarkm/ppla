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
      $scope.processing = true;
      CuttingProcessService.save({action: 'end'}, $scope.process, function (savedProcess) {
        alert('Cutting Process completed.');
        $scope.processing = false;
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
      $scope.processing = true;
      CuttingProcessService.save({action: 'pause'}, $scope.process, function () {
        alert('Process has been paused.');
        $scope.processing = false;
        $state.go('cutter.identity');
      });
    };
    $scope.resume = function () {
      $scope.processing = true;
      CuttingProcessService.save({action: 'resume'}, $scope.process, function () {
        alert('Process has been resumed.');
        $scope.processing = false;
        $state.go('cutter.identity');
      });
    };
  }]);
});
