angular.module('ppla.controllers')

.controller('SalesOrderController', function($scope, SalesOrderService, ngTableParams) {

  //SO browse table
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
      SalesOrderService.page(params.$params, function(response) {
        params.total(response.total);
        $defer.resolve(response.data);
      });
    }
  });
})