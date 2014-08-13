define([
  'angular',
  'bootstrap',
  'uiRouter',
  'ngResource',
  'ngTable',
  'ngQuickDate',
  'sugar',
  '/operations/controllers/op-controllers.js',
  '/operations/services.js',
  '/operations/filters.js'
], function (angular) {
  'use strict';
  return angular.module('op-app', [
    'ui.router',
    'ngResource',
    'ngTable',
    'ngQuickDate',
    'app.controllers',
    'app.services',
    'app.filters'
  ])
  
  .config(['ngQuickDateDefaultsProvider', function (ngQuickDateDefaultsProvider) {
     ngQuickDateDefaultsProvider.set('buttonIconHtml', '<i class="fa fa-clock-o"></i>');
     ngQuickDateDefaultsProvider.set('prevLinkHtml', '<i class="fa fa-chevron-left"></i>');
     ngQuickDateDefaultsProvider.set('nextLinkHtml', '<i class="fa fa-chevron-right"></i>');
     ngQuickDateDefaultsProvider.set('closeButtonHtml', '<i class="fa fa-times"></i>');
     ngQuickDateDefaultsProvider.set('parseDateFunction', function (str) {
       var d = Date.create(str);
       return d.isValid() ? d : null;
     });
   }]);

});