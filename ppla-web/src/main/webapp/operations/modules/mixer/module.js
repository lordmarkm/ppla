define(['/operations/app.js'], function(app) {
  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('mixer', {
      url: '/mixer',
      templateUrl: '/operations/modules/mixer/view/home.html',
      abstract: true,
      controller: 'MixerController'
    })
    .state('mixer.workorder', {
      url: '',
      templateUrl: '/operations/modules/mixer/view/workorder.html',
      controller: 'MixerWorkorderController'
    })
    .state('mixer.machine', {
      url: '/machine/{trackingNo}',
      templateUrl: '/operations/modules/mixer/view/machine.html',
      controller: 'MixerMachineController'
    });
  });
});