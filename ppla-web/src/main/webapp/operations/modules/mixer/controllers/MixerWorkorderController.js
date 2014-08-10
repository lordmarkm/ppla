define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerWorkorderController', ['$scope', '$state', 'ngTableParams', 'WorkOrderService',
    function($scope, $state, ngTableParams, WorkOrderService) {

    //Work orders
    $scope.tableParams = new ngTableParams({
      page: 1,
      count: 5,
      sorting: {
        trackingNo: 'asc'
      }
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

    $scope.useWorkorder = function (workOrder) {
      $scope.process.workOrderTrackingNo = workOrder.trackingNo;
      $state.go('mixer.machine');
    };

  }]);
});
