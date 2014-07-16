define([
  'angular',
  'uiRouter',
  'ngResource',
  'ngTable',
  '/operations/controllers/op-controllers.js',
  '/operations/services.js'
], function (angular) {
  'use strict';
  return angular.module('op-app', [
    'ui.router',
    'ngResource',
    'ngTable',
    'app.controllers',
    'app.services'
  ]);
});