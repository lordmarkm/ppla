define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('WorkOrderController', ['$scope', '$stateParams', 'WorkOrderService', 'OrderItemService', 'MaterialService', 'ProcessService',
    function($scope, $stateParams, WorkOrderService, OrderItemService, MaterialService, ProcessService) {

    $scope.trackingNo = $stateParams.trackingNo;
    $scope.workOrder = WorkOrderService.get({trackingNo: $scope.trackingNo});
    $scope.orderItems = OrderItemService.query({action: 'attached', workOrderTrackingNo: $scope.trackingNo});
    $scope.materials = MaterialService.query({type: $scope.trackingNo});
    $scope.processes = ProcessService.query({trackingNo: $scope.trackingNo}, initProductMap);
    $scope.processDetails = {};

    //Assumes a workorder will only produce 1 product type, meaning all cutting processes
    //will produce the same kind of product
    $scope.produced = 0;
    function initProductMap(processes) {
      var i = processes.length;
      while (i--) {
        if (processes[i].type == 'CUTTING') {
          $scope.produced += processes[i].productOut;
        }
      }
    }
  }]);
});
