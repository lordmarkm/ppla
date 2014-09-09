define([
  '/operations/app.js',
  '/operations/modules/printer/resolve/PrintingProcessResolve.js',
  '/operations/modules/printer/resolve/PrinterMachineResolve.js',
  '/operations/modules/printer/resolve/PrinterOutputMaterialResolve.js'
  ], 
  function(app, PrintingProcessResolve, PrinterMachineResolve, PrinterOutputMaterialResolve) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('printer', {
        url: '/printer',
        templateUrl: '/operations/modules/printer/view/home.html',
        abstract: true,
        controller: 'PrinterController'
      })
      .state('printer.identity', {
        url: '',
        templateUrl: '/operations/modules/printer/view/identity.html',
        controller: 'PrinterIdentityController'
      })
      .state('printer.scantag', {
        url: '/scantag',
        templateUrl: '/operations/modules/printer/view/scantag.html',
        controller: 'PrinterScantagController'
      })
      .state('printer.machine', {
        url: '/machine',
        templateUrl: '/operations/modules/printer/view/machine.html',
        controller: 'PrinterMachineController',
        resolve: PrinterMachineResolve
      })

      //Start process flow
      .state('printer.start', {
        url: '/start',
        templateUrl: '/operations/modules/printer/view/start/home.html',
        abstract: true,
        controller: 'PrinterStartController'
      })
      .state('printer.start.additional', {
        url: '/additional',
        templateUrl: '/operations/modules/printer/view/start/additional.html',
        controller: 'PrinterAdditionalController'
      })
      .state('printer.start.confirm', {
        url: '/confirm',
        controller: 'PrinterStartController'
      })

      //End process flow
      .state('printer.end', {
        url: '/end/{processId}',
        templateUrl: '/operations/modules/printer/view/end/home.html',
        controller: 'PrinterEndController',
        resolve: PrintingProcessResolve
      })
      .state('printer.end.confirm', {
        url: '/confirm',
        controller: 'PrinterEndController'
      });
    }
  );
});