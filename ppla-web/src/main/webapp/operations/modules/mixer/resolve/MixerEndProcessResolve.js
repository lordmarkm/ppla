define([], function() {
  'use strict';
  return {
    process: ['$stateParams', 'MixingProcessService', function ($stateParams, MixingProcessService) {
      console.debug('Querying mixing process with id=' + JSON.stringify($stateParams));
      return MixingProcessService.get({id: $stateParams.processId}).$promise;
    }]
  };
});