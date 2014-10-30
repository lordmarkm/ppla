angular.module('ppla')

.config(function ($stateProvider, $urlRouterProvider) {
  $stateProvider.state('inventory', {
    url: '/inventory',
    templateUrl: 'modules/inventory/view/inventory.html',
    controller: 'InventoryController'
  });
});
