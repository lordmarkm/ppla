angular.module('ppla.controllers')

.controller('SalesOrder_WorkOrdersController', function($scope, $stateParams, SalesOrderService) {

  $scope.trackingNo = $stateParams.trackingNo;
  $scope.salesorder = SalesOrderService.get({trackingNo:$stateParams.trackingNo});

});
