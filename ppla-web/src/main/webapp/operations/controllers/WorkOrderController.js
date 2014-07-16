define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WorkOrderController', ['$scope', '$stateParams', 'WorkOrderService', 'OrderItemService',
    function($scope, $stateParams, WorkOrderService, OrderItemService) {

    $scope.trackingNo = $stateParams.trackingNo;
    $scope.workOrder = WorkOrderService.get({trackingNo: $scope.trackingNo});
    $scope.orderItems = OrderItemService.query({action: 'attached', workOrderTrackingNo: $scope.trackingNo});

  }]);
});
