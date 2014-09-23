angular.module('ppla.controllers')

.controller('InventoryController', function($scope, $state, ngTableParams, InventoryService) {

  $scope.tableParams = new ngTableParams({
    page: 1,
    count: 5,
    sorting: {
      id: 'asc'
    }
  }, {
    total: 0,
    counts: [5,10,25,50,100], //determines pager
    getData: function($defer, params) {
      //Ajax request to backend resource
      InventoryService.page(params.$params, function(response) {
        params.total(response.total);
        $defer.resolve(response.data);
      });
    }
  });

});