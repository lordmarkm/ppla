define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WorkOrderController', ['$scope', '$stateParams', 'WorkOrderService', 'OrderItemService', 'MaterialService', 'ProcessService',
    function($scope, $stateParams, WorkOrderService, OrderItemService, MaterialService, ProcessService) {

    $scope.trackingNo = $stateParams.trackingNo;
    $scope.workOrder = WorkOrderService.get({trackingNo: $scope.trackingNo});
    $scope.orderItems = OrderItemService.query({action: 'attached', workOrderTrackingNo: $scope.trackingNo});
    $scope.materials = MaterialService.query({type: $scope.trackingNo});
    $scope.processes = ProcessService.query({trackingNo: $scope.trackingNo});
    $scope.processDetails = {};

    $scope.parseDate = function(dt) {
      return new Date(dt);
    };
  }]);
});
