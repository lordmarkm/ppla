angular.module('ppla.controllers')

.controller('SalesOrderController', function($scope, ngTableParams, ProductService, SalesOrderService) {

  $scope.salesorder = {
    orderItems: []
  };

  //Products
  ProductService.page({
    page: 1,
    count: 50
  }, function (response) {
    $scope.products = response.data;
  });

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

  //Add items
  $scope.addItem = function(item, quantity) {
    var correctQuantity = quantity ? quantity : 1;
    $scope.salesorder.orderItems.push({
      quantity: correctQuantity,
      product: item
    });
  };

  //Save salesorder
  $scope.saveSalesOrder = function () {
    if (!$scope.salesorder) {
      return false;
    }

    SalesOrderService.save($scope.salesorder, function(saved) {
      alert('Successfully saved SO. Tracking no=' + saved.trackingNo);
    });
  };
});