define([], function() {
  'use strict';
  return {
    material: ['MaterialService', function (MaterialService) {
      return MaterialService.query({type: 'process', source: 'EXTRUSION'}).$promise;
    }]
  };
});