define([], function() {
  'use strict';
  return {
    materials: ['MaterialService', function (MaterialService) {
      return MaterialService.query({type: 'process', source: 'CUTTING'}).$promise;
    }]
  };
});