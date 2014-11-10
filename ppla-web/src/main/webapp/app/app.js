angular.module('ppla', [
  'ui.router',
  'ui.bootstrap',
  'ppla.controllers',
  'ppla.services',
  'ppla.filters'
])

.config(function ($stateProvider, $urlRouterProvider) {

  //$urlRouterProvider.otherwise('/home');

  $stateProvider

    //home state
    .state('home', {
      url: '/home',
      templateUrl: 'home.html'
    })

    //Products management view
    .state('manage/product', {
      url: '/product',
      templateUrl: '/manage/product.html',
      controller: 'ProductController'
    })

    //Materials management view
    .state('manage/material', {
      url: '/material',
      templateUrl: '/manage/material.html',
      controller: 'MaterialController'
    })

    //Machines
    .state('manage/machines', {
      url: '/machines',
      templateUrl: '/manage/machines.html',
      controller: 'MachineController'
    })
    .state('machines_history', {
      url: '/machine/history/{type}/{machineId}',
      templateUrl: '/manage/machine_history.html',
      controller: 'MachineHistoryController'
    })

    //Sales orders management
    .state('manage/salesorder', {
      url: '/salesorder',
      templateUrl: '/manage/salesorder.html',
      controller: 'SalesOrderController'
    })
    .state('manage/salesorder/new', {
      url: '/salesorder/new',
      templateUrl: '/manage/salesorder_new.html',
      controller: 'SalesOrderController'
    })
    .state('manage/salesorder/workorders', {
      url: '/salesorder/workorders/{trackingNo}',
      templateUrl: '/manage/salesorder_workorders.html',
      controller: 'SalesOrder_WorkOrdersController'
    })
    .state('manage/orderitem', {
      url: '/orderitem/{id}?salesOrder',
      templateUrl: '/manage/orderitem.html',
      controller: 'OrderItemController'
    })

    //Work orders
    .state('manage/workorders', {
      url: '/workorders',
      templateUrl: '/manage/workorders.html',
      controller: 'WorkOrderBrowseController'
    })
    .state('manage/workorder', {
      url: '/workorder/{trackingNo}?salesOrder&orderItem',
      templateUrl: '/manage/workorder.html',
      controller: 'WorkOrderController'
    });
});