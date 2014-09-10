define([], function() {
  'use strict';
  return {
    process: ['$stateParams', 'CuttingProcessService', function ($stateParams, CuttingProcessService) {
      if ($stateParams.processId) {
        return CuttingProcessService.get({id: $stateParams.processId}).$promise;
      } else {
        return null;
      }
    }]
  };
});