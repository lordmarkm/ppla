angular.module('ppla', [
  'ui.router',
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
      url: 'manage/salesorder/workorders/{trackingNo}',
      templateUrl: 'manage/salesorder_workorders.html',
      controller: 'SalesOrder_WorkOrdersController'
    })
    .state('manage/workorder', {
      url: 'manage/workorder/{id}',
      templateUrl: 'manage/orderitem_workorder.html',
      controller: 'SalesOrder_WorkOrdersController'
    });
});