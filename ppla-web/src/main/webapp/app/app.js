angular.module('ppla', [
  'ui.router',
  'ui.bootstrap',
  'ppla.controllers',
  'ppla.services'
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
      url: '/manage/product',
      templateUrl: 'manage/product.html',
      controller: 'ProductController'
    })

    //Materials management view
    .state('manage/material', {
      url: '/manage/material',
      templateUrl: 'manage/material.html',
      controller: 'MaterialController'
    })

    //Machines
    .state('manage/machines', {
      url: '/manage/machines',
      templateUrl: 'manage/machines.html',
      controller: 'MachineController'
    })

    //Sales orders management
    .state('manage/salesorder', {
      url: '/manage/salesorder',
      templateUrl: 'manage/salesorder.html',
      controller: 'SalesOrderController'
    })
    .state('manage/salesorder/new', {
      url: '/manage/salesorder/new',
      templateUrl: 'manage/salesorder_new.html',
      controller: 'SalesOrderController'
    })
    .state('manage/salesorder/workorders', {
      url: '/manage/salesorder/workorders/{trackingNo}',
      templateUrl: 'manage/salesorder_workorders.html',
      controller: 'SalesOrder_WorkOrdersController'
    })
    .state('manage/orderitem', {
      url: '/manage/orderitem/{id}?salesOrder',
      templateUrl: 'manage/orderitem.html',
      controller: 'OrderItemController'
    })

    //Work orders
    .state('manage/workorders', {
      url: '/manage/workorders',
      templateUrl: 'manage/workorders.html',
      controller: 'WorkOrderBrowseController'
    })
    .state('manage/workorder', {
      url: '/manage/workorder/{trackingNo}?salesOrder&orderItem',
      templateUrl: 'manage/workorder.html',
      controller: 'WorkOrderController'
    });
});