define([
  '/operations/app.js',
  '/operations/modules/extruder/resolve/ExtrusionProcessResolve.js',
  '/operations/modules/extruder/resolve/ExtruderMachineResolve.js'
  ], 
  function(app, ExtrusionProcessResolve, ExtruderMachineResolve) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('extruder', {
        url: '/extruder',
        templateUrl: '/operations/modules/extruder/view/home.html',
        abstract: true,
        controller: 'ExtruderController'
      })
      .state('extruder.identity', {
        url: '',
        templateUrl: '/operations/modules/extruder/view/identity.html',
        controller: 'ExtruderIdentityController'
      })
      .state('extruder.machine', {
        url: '/machine',
        templateUrl: '/operations/modules/extruder/view/machine.html',
        controller: 'ExtruderMachineController',
        resolve: ExtruderMachineResolve
      })

      //Start process flow
      .state('extruder.start', {
        url: '/start',
        templateUrl: '/operations/modules/extruder/view/start/home.html',
        abstract: true,
        controller: 'ExtruderStartController',
        resolve: ExtrusionProcessResolve
      })
      .state('extruder.start.workorder', {
        url: '/workorder',
        templateUrl: '/operations/modules/extruder/view/start/workorder.html',
        controller: 'ExtruderWorkorderController'
      })
      .state('extruder.start.materials', {
        url: '/materials',
        templateUrl: '/operations/modules/extruder/view/start/materials.html',
        controller: 'ExtruderMaterialsController'
      })
      .state('extruder.start.confirm', {
        url: '/confirm',
        controller: 'ExtruderStartController'
      });
  
      //End process flow
//      .state('extruder.end', {
//        url: '/extruder/end/{processId}',
//        templateUrl: '/operations/modules/extruder/view/end/home.html',
//        controller: 'ExtruderEndController',
//        resolve: ExtruderEndProcessResolve
//      })
//      .state('extruder.end.materials', {
//        url: '/materials',
//        templateUrl: '/operations/modules/extruder/view/end/materials.html',
//        controller: 'ExtruderEndMaterialsController',
//        resolve: ExtruderOutputMaterialResolve
//      })
//      .state('extruder.end.confirm', {
//        url: '/confirm',
//        controller: 'ExtruderEndController'
//      })
//      .state('extruder.end.stageextrusion', {
//        url: '/stageextrusion',
//        templateUrl: '/operations/modules/extruder/view/end/stage_extrusion_processes.html',
//        controller: 'ExtruderStageExtrusionController',
//        resolve: ExtruderStageExtrusionResolve
//      });
    }
  );
});