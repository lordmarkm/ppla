define([], function() {
  'use strict';
  return {
    mixers: ['MachineService', 'MixingProcessService', function (MachineService, MixingProcessService) {
      return MachineService.query({type:'MIXING'}, function (machines) {
        var i = machines.length;
        while (i--) {
          machines[i].process = machines[i].currentProcessId ? MixingProcessService.get({id: machines[i].currentProcessId}) : {};
        }
      }).$promise;
    }]
  };
});