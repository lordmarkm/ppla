define([], function() {
  'use strict';
  return {
    cutters: ['MachineService', function (MachineService) {
      return MachineService.query({type:'CUTTING'}).$promise;
    }]
  };
});