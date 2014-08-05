define(['/operations/app.js'], function(app) {
  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('mixer', {
      url: '/mixer',
      templateUrl: '/operations/modules/mixer/view/home.html'
    })
    .state('mixer.machine', {
      url: '/machine',
      templateUrl: '/operations/modules/mixer/view/machine.html',
      controller: 'MixerController'
    })
    .state('mixer.workorder', {
      url: 'workorder/{machineCode}',
      templateUrl: '/operations/modules/mixer/view/workorder.html',
      controller: 'MixerWorkorderController'
    });
  });
});