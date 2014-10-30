define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerWorkorderController', ['$scope', '$state', 'ngTableParams', 'WorkOrderService',
    function($scope, $state, ngTableParams, WorkOrderService) {

    $scope.workOrders = [];

    //Work orders
    $scope.tableParams = new ngTableParams({
      page: 1,
      count: 5,
      sorting: {
        trackingNo: 'asc'
      },
      closed: false
    }, {
      total: 0,
      counts: [], //hides pager
      getData: function($defer, params) {
        //Ajax request to backend resource
        WorkOrderService.page(params.$params, function(response) {
          params.total(response.total);
          $defer.resolve(response.data);
        });
      }
    });

    $scope.isAttached = function (toCheck) {
      var i = $scope.workOrders.length, workOrder;
      while (i--) {
        workOrder = $scope.workOrders[i];
        if (workOrder.trackingNo == toCheck.trackingNo) {
          return true;
        }
      }
      return false;
    };

    $scope.remove = function (toRemove) {
      var i = $scope.workOrders.length, workOrder;
      while (i--) {
        workOrder = $scope.workOrders[i];
        if (workOrder.trackingNo == toRemove.trackingNo) {
          $scope.workOrders.splice(i, 1);
        }
      }
    };

    $scope.saveWorkorders = function () {
      $scope.process.workOrders = $scope.workOrders;
      $state.go($scope.nextState());
    };

  }]);
});
