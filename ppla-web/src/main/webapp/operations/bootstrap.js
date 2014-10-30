define([
  'require',
  'angular',
  'app.js',
  'routes.js',
  'modules/mixer/module.js',
  'modules/warehouse/module.js',
  'modules/extruder/module.js',
  'modules/printer/module.js',
  'modules/cutter/module.js'
], function (require, angular) {
  'use strict';
  require(['domReady!'], function (document) {
    angular.bootstrap(document, ['op-app']);
  });
});