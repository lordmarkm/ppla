define([
  'app.js',
  'modules/cutter/resolve/CuttingProcessResolve.js',
  'modules/cutter/resolve/CutterMachineResolve.js',
  'modules/cutter/resolve/CutterOutputMaterialResolve.js'
  ], 
  function(app, CuttingProcessResolve, CutterMachineResolve, CutterOutputMaterialResolve) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('cutter_summary', {
        url: '/cutter/summary/{processId}',
        templateUrl: 'modules/cutter/view/summary.html',
        controller: 'CutterSummaryController',
        resolve: CuttingProcessResolve
      })

      //flow control
      .state('cutter', {
        url: '/cutter',
        templateUrl: 'modules/cutter/view/home.html',
        abstract: true,
        controller: 'CutterController'
      })
      .state('cutter.identity', {
        url: '',
        templateUrl: 'modules/cutter/view/identity.html',
        controller: 'CutterIdentityController'
      })
      .state('cutter.scantag', {
        url: '/scantag',
        templateUrl: 'modules/cutter/view/scantag.html',
        controller: 'CutterScantagController'
      })
      .state('cutter.machine', {
        url: '/machine',
        templateUrl: 'modules/cutter/view/machine.html',
        controller: 'CutterMachineController',
        resolve: CutterMachineResolve
      })

      //Start process flow
      .state('cutter.start', {
        url: '/start',
        templateUrl: 'modules/cutter/view/start/home.html',
        abstract: true,
        controller: 'CutterStartController'
      })
      .state('cutter.start.additional', {
        url: '/additional',
        templateUrl: 'modules/cutter/view/start/additional.html',
        controller: 'CutterAdditionalController'
      })
      .state('cutter.start.confirm', {
        url: '/confirm',
        controller: 'CutterStartController'
      })

      //End process flow
      .state('cutter.end', {
        url: '/end/{processId}',
        templateUrl: 'modules/cutter/view/end/home.html',
        controller: 'CutterEndController',
        resolve: CuttingProcessResolve
      })
      .state('cutter.end.materials', {
        url: '/materials',
        templateUrl: 'modules/cutter/view/end/materials.html',
        controller: 'CutterEndMaterialsController'
      })
      .state('cutter.end.confirm', {
        url: '/confirm',
        controller: 'CutterEndController'
      });
    }
  );
});