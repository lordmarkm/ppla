angular.module('ppla.controllers')

.controller('WorkOrderController', function($scope, $state, $stateParams, WorkOrderService, OrderItemService) {

  $scope.trackingNo = $stateParams.trackingNo;
  $scope.workOrder = WorkOrderService.get({trackingNo: $scope.trackingNo});
  $scope.orderItems = OrderItemService.query({action: 'attached', workOrderTrackingNo: $scope.trackingNo});
  $scope.params = $state.params;

  $scope.closeWorkOrder = function () {
    if (!confirm('Are you sure you want to close this work order?')) {
      return false;
    }

    WorkOrderService.close({trackingNo: $scope.trackingNo}, null, function(closed) {
      $scope.workOrder = closed;
    });
  };
});
