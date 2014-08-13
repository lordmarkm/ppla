define(['/operations/app.js'], function(app) {
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
      controller: 'MixerMachineController'
    })
    .state('mixer.workorder', {
      url: '/workorder',
      templateUrl: '/operations/modules/mixer/view/workorder.html',
      controller: 'MixerWorkorderController'
    })
    .state('mixer.materials', {
      url: '/materials',
      templateUrl: '/operations/modules/mixer/view/materials.html',
      controller: 'MixerMaterialsController'
    })
    .state('mixer.additional', {
      url: '/additional',
      templateUrl: '/operations/modules/mixer/view/additional.html',
      controller: 'MixerAdditionalController'
    })
    .state('mixer.confirm', {
      url: '/confirm',
      controller: 'MixerController'
    });
  });
});