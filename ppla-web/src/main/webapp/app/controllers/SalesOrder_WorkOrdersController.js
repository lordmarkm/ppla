angular.module('ppla.controllers')

.controller('SalesOrder_WorkOrdersController', function($scope, $stateParams, SalesOrderService) {

  console.debug('Yep.');
  $scope.trackingNo = $stateParams.trackingNo;
  $scope.salesorder = SalesOrderService.get({trackingNo:$scope.trackingNo});

});