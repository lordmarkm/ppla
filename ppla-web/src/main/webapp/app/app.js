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
      url: 'manage/salesorder/{trackingNo}/workorders',
      templateUrl: 'manage/salesorder_workorders.html',
      controller: 'SalesOrder_WorkOrdersController'
    });

});