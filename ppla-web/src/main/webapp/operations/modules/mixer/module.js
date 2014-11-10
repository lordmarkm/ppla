define([
  '/operations/app.js',
  '/operations/modules/mixer/resolve/MixerMachineResolve.js',
  '/operations/modules/mixer/resolve/MixerEndProcessResolve.js',
  '/operations/modules/mixer/resolve/MixerStageExtrusionResolve.js',
  '/operations/modules/mixer/resolve/MixerOutputMaterialResolve.js'
  ], 
  function(app, MixerMachineResolve, MixerEndProcessResolve, MixerStageExtrusionResolve, MixerOutputMaterialResolve) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('mixer', {
        url: '/mixer',
        templateUrl: '/operations/modules/mixer/view/home.html',
        abstract: true,
        controller: 'MixerController'
      })
      .state('mixer.identity', {
        url: '',
        templateUrl: '/operations/modules/mixer/view/identity.html',
        controller: 'MixerIdentityController'
      })
      .state('mixer.machine', {
        url: '/machine',
        templateUrl: '/operations/modules/mixer/view/machine.html',
        controller: 'MixerMachineController',
        resolve: MixerMachineResolve
      })

      //Start process flow
      .state('mixer.start', {
        url: '/start',
        templateUrl: '/operations/modules/mixer/view/start/home.html',
        abstract: true,
        controller: 'MixerStartController'
      })
      .state('mixer.start.workorder', {
        url: '/workorder',
        templateUrl: '/operations/modules/mixer/view/start/workorder.html',
        controller: 'MixerWorkorderController'
      })
      .state('mixer.start.materials', {
        url: '/materials',
        templateUrl: '/operations/modules/mixer/view/start/materials.html',
        controller: 'MixerMaterialsController'
      })
      .state('mixer.start.additional', {
        url: '/additional',
        templateUrl: '/operations/modules/mixer/view/start/additional.html',
        controller: 'MixerAdditionalController'
      })
      .state('mixer.start.confirm', {
        url: '/confirm',
        controller: 'MixerStartController'
      })
  
      //End process flow
      .state('mixer.end', {
        url: '/end/{processId}',
        templateUrl: '/operations/modules/mixer/view/end/home.html',
        controller: 'MixerEndController',
        resolve: MixerEndProcessResolve
      })
      .state('mixer.end.materials', {
        url: '/materials',
        templateUrl: '/operations/modules/mixer/view/end/materials.html',
        controller: 'MixerEndMaterialsController',
        resolve: MixerOutputMaterialResolve
      })
      .state('mixer.end.confirm', {
        url: '/confirm',
        controller: 'MixerEndController'
      })
      .state('mixer.end.stageextrusion', {
        url: '/stageextrusion',
        templateUrl: '/operations/modules/mixer/view/end/stage_extrusion_processes.html',
        controller: 'MixerStageExtrusionController',
        resolve: MixerStageExtrusionResolve
      });
    }
  );
});