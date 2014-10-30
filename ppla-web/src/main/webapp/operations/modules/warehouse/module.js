define([
    'app.js'
  ], function(app) {

  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('warehouse', {
      url: '/warehouse',
      templateUrl: 'modules/warehouse/view/home.html',
      abstract: true,
      controller: 'WarehouseController'
    })
    .state('warehouse.identity', {
      url: '',
      templateUrl: 'modules/warehouse/view/identity.html',
      controller: 'WarehouseIdentityController'
    })
    .state('warehouse.workorder', {
      url: '/workorder',
      templateUrl: 'modules/warehouse/view/workorder.html',
      controller: 'WarehouseWorkorderController'
    })
    .state('warehouse.materials', {
      url: '/materials',
      templateUrl: 'modules/warehouse/view/materials.html',
      controller: 'WarehouseMaterialsController'
    })
    .state('warehouse.additional', {
      url: '/additional',
      templateUrl: 'modules/warehouse/view/additional.html',
      controller: 'WarehouseAdditionalController'
    })
    .state('warehouse.confirm', {
      url: '/confirm',
      controller: 'WarehouseController'
    });
  });
});