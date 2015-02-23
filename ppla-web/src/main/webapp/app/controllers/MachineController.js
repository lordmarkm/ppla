angular.module('ppla.controllers')

.controller('MachineController', function($scope, MachineService,
    MixingProcessService, ExtrusionProcessService, PrintingProcessService, CuttingProcessService) {

  loadMachines();

  function loadMachines() {
    $scope.machines = MachineService.get(function(machines) {
      var i = machines.mixers.length;
      while (i--) {
        machines.mixers[i].process = machines.mixers[i].currentProcessId ? MixingProcessService.get({id: machines.mixers[i].currentProcessId}) : {};
      }
  
      i = machines.extruders.length;
      while (i--) {
        machines.extruders[i].process = machines.extruders[i].currentProcessId ? ExtrusionProcessService.get({id: machines.extruders[i].currentProcessId}) : {};
      }
  
      i = machines.printers.length;
      while (i--) {
        machines.printers[i].process = machines.printers[i].currentProcessId ? PrintingProcessService.get({id: machines.printers[i].currentProcessId}) : {};
      }
  
      i = machines.cutters.length;
      while (i--) {
        machines.cutters[i].process = machines.cutters[i].currentProcessId ? CuttingProcessService.get({id: machines.cutters[i].currentProcessId}) : {};
      }
    });
  }

  $scope.saveMachine = function () {
    MachineService.save({type: $scope.machine.type}, $scope.machine, function(saved) {
      alert('Machine details successfully saved.');
      if (!$scope.machine.id) {
      switch($scope.machine.type) {
        case 'MIXING':
          $scope.machines.mixers.push(saved);
          break;
        case 'EXTRUSION':
          $scope.machines.extruders.push(saved);
          break;
        case 'PRINTING':
          $scope.machines.printers.push(saved);
          break;
        case 'CUTTING':
          $scope.machines.cutters.push(saved);
          break;
        }
      }
      $scope.machine = {type:$scope.machine.type};
    });
  };

  $scope.deleteMachine = function (machine) {
    if (machine.currentProcessId) {
      alert('End current process first.');
      return false;
    }
    if (!confirm('This will permanently delete this machine. Continue?')) {
      return false;
    }
    MachineService.remove({id: machine.id, type: machine.type}, {}, loadMachines);
  };
});