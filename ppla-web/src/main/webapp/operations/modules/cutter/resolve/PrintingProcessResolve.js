define([], function() {
  'use strict';
  return {
    process: ['$stateParams', 'PrintingProcessService', function ($stateParams, PrintingProcessService) {
      if ($stateParams.processId) {
        return PrintingProcessService.get({id: $stateParams.processId}).$promise;
      } else {
        return null;
      }
    }]
  };
});