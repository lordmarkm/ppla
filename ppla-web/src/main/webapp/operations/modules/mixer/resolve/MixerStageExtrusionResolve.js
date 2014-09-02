define([], function() {
  'use strict';
  return {
    extruders: ['MachineService', function (MachineService) {
      return MachineService.query({type:'EXTRUSION'}).$promise;
    }]
  };
});