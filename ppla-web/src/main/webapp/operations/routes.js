define(['/operations/app.js'], function(app) {
  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('home', {
      url: '/',
      templateUrl: '/operations/view/home.html'
    })
    .state('profile', {
      url: '/profile',
      templateUrl: '/common/view/profile.html',
      controller: 'ProfileController'
    })
    .state('workorders', {
      url: '/workorders',
      templateUrl: '/operations/view/workorders.html',
      controller: 'WorkOrderBrowseController'
    })
    .state('workorder', {
      url: '/workorder/{trackingNo}',
      templateUrl: '/operations/view/workorder.html',
      controller: 'WorkOrderController'
    })
    .state('warehouse_process', {
      url: '/process/warehouse/{trackingNo}/{processId}',
      templateUrl: '/operations/view/process_warehouse.html',
      controller: 'WarehouseProcessController'
    });
  });
});