angular.module('ppla.controllers')

.controller('WorkOrderBrowseController', function($scope, ngTableParams, WorkOrderService) {
  //WO browse table
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
});