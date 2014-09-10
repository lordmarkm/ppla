define([
  '/operations/app.js',
  '/operations/modules/cutter/resolve/CuttingProcessResolve.js',
  '/operations/modules/cutter/resolve/CutterMachineResolve.js',
  '/operations/modules/cutter/resolve/CutterOutputMaterialResolve.js'
  ], 
  function(app, CuttingProcessResolve, CutterMachineResolve, CutterOutputMaterialResolve) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('cutter', {
        url: '/cutter',
        templateUrl: '/operations/modules/cutter/view/home.html',
        abstract: true,
        controller: 'CutterController'
      })
      .state('cutter.identity', {
        url: '',
        templateUrl: '/operations/modules/cutter/view/identity.html',
        controller: 'CutterIdentityController'
      })
      .state('cutter.scantag', {
        url: '/scantag',
        templateUrl: '/operations/modules/cutter/view/scantag.html',
        controller: 'CutterScantagController'
      })
      .state('cutter.machine', {
        url: '/machine',
        templateUrl: '/operations/modules/cutter/view/machine.html',
        controller: 'CutterMachineController',
        resolve: CutterMachineResolve
      })

      //Start process flow
      .state('cutter.start', {
        url: '/start',
        templateUrl: '/operations/modules/cutter/view/start/home.html',
        abstract: true,
        controller: 'CutterStartController'
      })
      .state('cutter.start.additional', {
        url: '/additional',
        templateUrl: '/operations/modules/cutter/view/start/additional.html',
        controller: 'CutterAdditionalController'
      })
      .state('cutter.start.confirm', {
        url: '/confirm',
        controller: 'CutterStartController'
      })

      //End process flow
      .state('cutter.end', {
        url: '/end/{processId}',
        templateUrl: '/operations/modules/cutter/view/end/home.html',
        controller: 'CutterEndController',
        resolve: CuttingProcessResolve
      })
      .state('cutter.end.confirm', {
        url: '/confirm',
        controller: 'CutterEndController'
      });
    }
  );
});