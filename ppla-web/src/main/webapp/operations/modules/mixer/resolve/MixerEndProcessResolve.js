define([], function() {
  'use strict';
  return {
    process: ['$stateParams', 'MixingProcessService', function ($stateParams, MixingProcessService) {
      return MixingProcessService.get({id: $stateParams.processId}).$promise;
    }]
  };
});