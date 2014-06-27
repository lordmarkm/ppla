angular.module('ppla.controllers', [])

.controller('SalesOrderController', function($scope, SalesOrderService) {
  $scope.name = 'SO Controller';

  console.debug(SalesOrderService.get());

})