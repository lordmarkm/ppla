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

    //for screens where there are no required fields
    $scope.meta = {
      additionalsSaved : false
    };

    $scope.confirmEnd = function () {
      delete $scope.process.type;
      $scope.processing = true;
      ExtrusionProcessService.save({action: 'end'}, $scope.process, function (savedProcess) {
        var code = savedProcess.materialsOut[0].tag;
        alert('Extrusion Process completed. Output roll code=' + code);
        $scope.processing = false;
        $scope.process = savedProcess;

        angular.element('#scannable-code').barcode(code, "ean13", {barWidth:2, barHeight:100});
        $scope.process = savedProcess;
      });
    };

    $scope.confirmUnload = function () {
      delete $scope.process.type;
      $scope.processing = true;
      ExtrusionProcessService.save({action: 'unload'}, $scope.process, function (savedProcess) {
        var code = savedProcess.materialsOut[0].tag;
        alert('Roll unloaded. Output roll code=' + code);
        $scope.processing = false;

        angular.element('#scannable-code').barcode(code, "ean13", {barWidth:2, barHeight:100});
        $scope.process = savedProcess;
      });
    };

    $scope.processStatus = function () {
      if (!$scope.process.endActor) {
        return 'No end actor';
      } else if (!$scope.process.materialsOut.length) {
        return 'None positive material output';
      } else if (!$scope.meta.additionalsSaved) {
        return 'Remarks';
      } else if ($scope.process.dateCompleted) {
        return 'Completed';
      } else {
        return 'Complete';
      }
    };

    $scope.printTags = function () {
      if ($scope.process.materialsOut.length) {
        var tagstr = '', i = $scope.process.materialsOut.length;
        while (i--) {
          tagstr += $scope.process.materialsOut[i].tag;
          if (i != 0) {
            tagstr += ',';
          }
        }
        $window.open(print_url + $scope.process.id + '/' + tagstr);
      }
    };

    $scope.directPrintTags = function () {
      $window.print();
    };

  }]);
});
