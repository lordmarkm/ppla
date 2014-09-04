define([], function() {
  'use strict';
  return {
    process: ['$stateParams', 'ExtrusionProcessService', function ($stateParams, ExtrusionProcessService) {
      if ($stateParams.processId) {
        return ExtrusionProcessService.get({id: $stateParams.processId}).$promise;
      } else {
        return null;
      }
    }]
  };
});