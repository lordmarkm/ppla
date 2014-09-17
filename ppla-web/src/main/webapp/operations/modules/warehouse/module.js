define([
    '/operations/app.js'
  ], function(app) {

  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('warehouse', {
      url: '/warehouse',
      templateUrl: '/operations/modules/warehouse/view/home.html',
      abstract: true,
      controller: 'WarehouseController'
    })
    .state('warehouse.identity', {
      url: '',
      templateUrl: '/operations/modules/warehouse/view/identity.html',
      controller: 'WarehouseIdentityController'
    })
    .state('warehouse.workorder', {
      url: '/workorder',
      templateUrl: '/operations/modules/warehouse/view/workorder.html',
      controller: 'WarehouseWorkorderController'
    })
    .state('warehouse.materials', {
      url: '/materials',
      templateUrl: '/operations/modules/warehouse/view/materials.html',
      controller: 'WarehouseMaterialsController'
    })
    .state('warehouse.additional', {
      url: '/additional',
      templateUrl: '/operations/modules/warehouse/view/additional.html',
      controller: 'WarehouseAdditionalController'
    })
    .state('warehouse.confirm', {
      url: '/confirm',
      controller: 'WarehouseController'
    });
  });
});