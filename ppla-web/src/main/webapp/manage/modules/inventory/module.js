angular.module('ppla')

.config(function ($stateProvider, $urlRouterProvider) {
  $stateProvider.state('inventory', {
    url: '/inventory',
    templateUrl: 'manage/modules/inventory/view/inventory.html',
    controller: 'InventoryController'
  });
});
