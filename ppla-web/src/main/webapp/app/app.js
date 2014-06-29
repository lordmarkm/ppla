angular.module('ppla', [
  'ui.router',
  'ppla.controllers',
  'ppla.services'
])

.config(function ($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.otherwise('/home');

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
      templateUrl: 'manage/salesorder.html'
    })

});