define([], function() {
  'use strict';
  return {
    printers: ['MachineService', 'PrintingProcessService', function (MachineService, PrintingProcessService) {
      return MachineService.query({type:'PRINTING'}, function (machines) {
        var i = machines.length;
        while (i--) {
          machines[i].process = machines[i].currentProcessId ? PrintingProcessService.get({id: machines[i].currentProcessId}) : {};
        }
      }).$promise;
    }]
  };
});