define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixingProcessController', ['$state', '$scope', '$stateParams', 'MaterialService', 'MixingProcessService',
    function($state, $scope, $stateParams, MaterialService) {

    $scope.trackingNo = $stateParams.trackingNo;
    $scope.dirty = false;
    $scope.process = {
        workOrderTrackingNo : $scope.trackingNo,
        inputMaterialStacks : []
    };

  }]);
});
