define([], function() {
  'use strict';
  return {
    printers: ['MachineService', function (MachineService) {
      return MachineService.query({type:'PRINTING'}).$promise;
    }]
  };
});