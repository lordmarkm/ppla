define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WorkOrderController', ['$scope', '$stateParams', 'WorkOrderService', 'OrderItemService', 'MaterialService',
    function($scope, $stateParams, WorkOrderService, OrderItemService, MaterialService) {

    $scope.trackingNo = $stateParams.trackingNo;
    $scope.workOrder = WorkOrderService.get({trackingNo: $scope.trackingNo});
    $scope.orderItems = OrderItemService.query({action: 'attached', workOrderTrackingNo: $scope.trackingNo});
    $scope.materials = MaterialService.query({type: $scope.trackingNo});
    $scope.processes = ProcessService.query({trackingNo: $scope.trackingNo});

  }]);
});
