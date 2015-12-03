angular.module('ppla.controllers')

.controller('ManualWorkOrderCreationController', function($scope, $state, products, WorkOrderService) {

  $scope.controllerName = 'ManualWorkOrderCreationController';
  $scope.products = products;
  $scope.wo = {};

  $scope.submit = function () {
    WorkOrderService.save($scope.wo, function () {
      $state.go('manage/workorders');
    });
  };

});