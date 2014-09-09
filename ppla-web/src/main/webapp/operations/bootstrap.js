define([
  'require',
  'angular',
  '/operations/app.js',
  '/operations/routes.js',
  '/operations/modules/mixer/module.js',
  '/operations/modules/warehouse/module.js',
  '/operations/modules/extruder/module.js',
  '/operations/modules/printer/module.js'
], function (require, angular) {
  'use strict';
  require(['domReady!'], function (document) {
    angular.bootstrap(document, ['op-app']);
  });
});