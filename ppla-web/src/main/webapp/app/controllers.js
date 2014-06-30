angular.module('ppla.controllers', ['ngTable'])

.controller('ProductController', function($scope, ProductService, ngTableParams) {

  $scope.saveProduct = function () {
    ProductService.save($scope.product, function (response) {
      alert('Successfully saved ' + response.name);
      $scope.tableParams.reload();
    });
  };
  
  $scope.deleteProduct = function (product) {
    if (!confirm('Are you sure you want to delete ' + product.name + '?')) {
      return false;
    }
    ProductService.delete({id: product.id}, function () {
      alert('Successfully deleted ' + product.name);
      $scope.tableParams.reload();
    });
  }

  $scope.tableParams = new ngTableParams({
    page: 1,
    count: 5,
    sorting: {
      id: 'asc'
    }
  }, {
    total: 0,
    counts: [], //hides pager
    getData: function($defer, params) {
      //Ajax request to backend resource
      ProductService.page(params.$params, function(response) {
        params.total(response.total);
        $defer.resolve(response.data);
      });
    }
  });
});