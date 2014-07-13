angular.module('ppla.controllers')

.controller('OrderItem_WorkOrderController', function($scope, $stateParams, OrderItemService, WorkOrderService) {

  $scope.id = $stateParams.id;
  $scope.orderItem = OrderItemService.get($scope.id);

  $scope.save = function () {
    WorkOrderService.save({orderItemId: $scope.id, workOrder: $scope.workOrder}, function (workOrder) {
      $scope.orderItem.workOrder = workOrder;
    });
  };

  $scope.attach = function () {
    WorkOrderService.put({orderItemId: $scope.id, trackingNo: $scope.trackingNo}, function (workOrder) {
      $scope.orderItem.workOrder = workOrder;
    });
  };
});
