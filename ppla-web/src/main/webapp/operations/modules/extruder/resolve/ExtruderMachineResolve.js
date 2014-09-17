define([], function() {
  'use strict';
  return {
    extruders: ['MachineService', 'ExtrusionProcessService', function (MachineService, ExtrusionProcessService) {
      return MachineService.query({type:'EXTRUSION'}, function (machines) {
        var i = machines.length;
        while (i--) {
          machines[i].process = machines[i].currentProcessId ? ExtrusionProcessService.get({id: machines[i].currentProcessId}) : {};
        }
      }).$promise;
    }]
  };
});