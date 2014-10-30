define(['app.js'], function(app) {
  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('home', {
      url: '/',
      templateUrl: 'view/home.html'
    })
    .state('profile', {
      url: '/profile?msg',
      templateUrl: 'view/profile.html',
      controller: 'ProfileController'
    })
    .state('workorders', {
      url: '/workorders',
      templateUrl: 'view/workorders.html',
      controller: 'WorkOrderBrowseController'
    })
    .state('workorder', {
      url: '/workorder/{trackingNo}',
      templateUrl: 'view/workorder.html',
      controller: 'WorkOrderController'
    })
    .state('warehouse_process', {
      url: '/process/warehouse/{trackingNo}/{processId}',
      templateUrl: 'view/process_warehouse.html',
      controller: 'WarehouseProcessController'
    })
    .state('mixing_process', {
      url: '/process/mixing/{trackingNo}/{processId}?initMat',
      templateUrl: 'view/process_mixing.html',
      controller: 'MixingProcessController'
    });
  });
});