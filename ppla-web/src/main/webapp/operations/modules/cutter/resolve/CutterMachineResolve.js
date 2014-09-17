define([], function() {
  'use strict';
  return {
    cutters: ['MachineService', 'CuttingProcessService', function (MachineService, CuttingProcessService) {
      return MachineService.query({type:'CUTTING'}, function (machines) {
        var i = machines.length;
        while (i--) {
          machines[i].process = machines[i].currentProcessId ? CuttingProcessService.get({id: machines[i].currentProcessId}) : {};
        }
      }).$promise;
    }]
  };
});