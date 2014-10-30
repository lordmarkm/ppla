define([
  'app.js',
  'modules/printer/resolve/PrintingProcessResolve.js',
  'modules/printer/resolve/PrinterMachineResolve.js',
  'modules/printer/resolve/PrinterOutputMaterialResolve.js'
  ], 
  function(app, PrintingProcessResolve, PrinterMachineResolve, PrinterOutputMaterialResolve) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('printer', {
        url: '/printer',
        templateUrl: 'modules/printer/view/home.html',
        abstract: true,
        controller: 'PrinterController'
      })
      .state('printer.identity', {
        url: '',
        templateUrl: 'modules/printer/view/identity.html',
        controller: 'PrinterIdentityController'
      })
      .state('printer.scantag', {
        url: '/scantag',
        templateUrl: 'modules/printer/view/scantag.html',
        controller: 'PrinterScantagController'
      })
      .state('printer.machine', {
        url: '/machine',
        templateUrl: 'modules/printer/view/machine.html',
        controller: 'PrinterMachineController',
        resolve: PrinterMachineResolve
      })

      //Start process flow
      .state('printer.start', {
        url: '/start',
        templateUrl: 'modules/printer/view/start/home.html',
        abstract: true,
        controller: 'PrinterStartController'
      })
      .state('printer.start.additional', {
        url: '/additional',
        templateUrl: 'modules/printer/view/start/additional.html',
        controller: 'PrinterAdditionalController'
      })
      .state('printer.start.confirm', {
        url: '/confirm',
        controller: 'PrinterStartController'
      })

      //End process flow
      .state('printer.end', {
        url: '/end/{processId}',
        templateUrl: 'modules/printer/view/end/home.html',
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