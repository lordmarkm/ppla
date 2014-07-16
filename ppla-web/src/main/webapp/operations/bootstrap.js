define([
  'require',
  'angular',
  '/operations/app.js',
  '/operations/routes.js'
], function (require, angular) {
  'use strict';
  require(['domReady!'], function (document) {
    angular.bootstrap(document, ['op-app']);
  });
});