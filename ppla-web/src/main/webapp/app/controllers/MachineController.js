angular.module('ppla.controllers')

.controller('MachineController', function($scope, MachineService) {

  $scope.machines = MachineService.get();

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
});