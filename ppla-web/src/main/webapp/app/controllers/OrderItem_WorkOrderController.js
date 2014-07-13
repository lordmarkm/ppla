angular.module('ppla.controllers')

.controller('OrderItem_WorkOrderController', function($scope, $stateParams, OrderItemService, WorkOrderService) {

  $scope.id = $stateParams.id;
  $scope.orderItem = OrderItemService.get({id: $scope.id});
  $scope.attachables = WorkOrderService.query({action: 'sameproduct', orderItemId: $scope.id});

  $scope.createNew = function () {
    WorkOrderService.save({action: 'new', orderItemId: $scope.id, workOrder: $scope.workOrder}, function (workOrder) {
      $scope.orderItem.workOrder = workOrder;
    });
  };

  $scope.attach = function () {
    WorkOrderService.put({action: 'attach', orderItemId: $scope.id, trackingNo: $scope.trackingNo}, function (workOrder) {
      $scope.orderItem.workOrder = workOrder;
    });
  };
});
