define([], function() {
  'use strict';
  return {
    machines: ['MachineService', function (MachineService) {
      return MachineService.query({type:'EXTRUSION'}).$promise;
    }]
  };
});