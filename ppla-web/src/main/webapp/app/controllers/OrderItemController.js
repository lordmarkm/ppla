angular.module('ppla.controllers')

.controller('OrderItemController', function($scope, $state, $stateParams, OrderItemService, WorkOrderService) {

  $scope.workOrder = {};
  $scope.id = $stateParams.id;
  $scope.attachables = [];
  $scope.attached = [];
  $scope.params = $state.params;

  //the order item being viewed
  $scope.orderItem = OrderItemService.get({id: $scope.id}, function (orderItem) {
    if (!orderItem.workOrder) {
      $scope.attachables = WorkOrderService.query({action: 'sameproduct', orderItemId: $scope.id});
    } else {
      OrderItemService.query({action: 'attached', workOrderTrackingNo: orderItem.workOrder.trackingNo}, function (attached) {
        for (var i = 0, len = attached.length; i < len; i++) {
          if (attached[i] && attached[i].id === parseInt($scope.id)) {
            attached.splice(i, 1);
          }
        }
        $scope.attached = attached;
      });
    }
  });

  $scope.createNew = function () {
    console.debug('Attempting to create new');
    WorkOrderService.save({action: 'new', orderItemId: $scope.id}, $scope.workOrder, function (workOrder) {
      $scope.orderItem.workOrder = workOrder;
    });
  };

  $scope.attach = function () {
    console.debug('Attempting to attach');
    WorkOrderService.save({action: 'attach', orderItemId: $scope.id, trackingNo: $scope.workOrder.trackingNo}, null, function (workOrder) {
      $scope.orderItem.workOrder = workOrder;
      $scope.attached = OrderItemService.query({action: 'attached', workOrderTrackingNo: workOrder.trackingNo});
    });
  };
});
