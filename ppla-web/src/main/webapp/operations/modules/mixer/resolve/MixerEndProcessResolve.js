define([], function() {
  'use strict';
  return {
    process: ['$stateParams', 'MixingProcessService', function ($stateParams, MixingProcessService) {
      return MixingProcessService.get({id: $stateParams.processId}).$promise;
    }],
    material: ['MaterialService', function (MaterialService) {
      return MaterialService.query({type: 'process', source: 'MIXING'}).$promise;
    }]
  };
});