define([], function() {
  'use strict';
  return {
    mixers: ['MachineService', function (MachineService) {
      return MachineService.query({type:'MIXING'}).$promise;
    }]
  };
});