angular.module('ppla.controllers')

.controller('MachineHistoryController', function($scope, $stateParams, ngTableParams, MachineService,
    MixingProcessService, ExtrusionProcessService, PrintingProcessService, CuttingProcessService) {

  $scope.machine = MachineService.get({type: $stateParams.type, id: $stateParams.machineId}, function (machine) {
    switch(machine.type) {
    case 'MIXING':
      $scope.currentProcess = machine.currentProcessId ? MixingProcessService.get({id: machine.currentProcessId}) : undefined;
      break;
    case 'EXTRUSION':
      $scope.currentProcess = machine.currentProcessId ? ExtrusionProcessService.get({id: machine.currentProcessId}) : undefined;
      break;
    case 'PRINTING':
      $scope.currentProcess = machine.currentProcessId ? PrintingProcessService.get({id: machine.currentProcessId}) : undefined;
      break;
    case 'CUTTING':
      $scope.currentProcess = machine.currentProcessId ? CuttingProcessService.get({id: machine.currentProcessId}) : undefined;
      break;
    }
  }, function () {
    $scope.machine = undefined;
  });

  $scope.tableParams = new ngTableParams({
    page: 1,
    count: 5,
    sorting: {
      id: 'desc'
    },
    machineId: $stateParams.machineId || 0
  }, {
    total: 0,
    counts: [5,10,25,50,100], //determines pager
    getData: function($defer, params) {
      if (!$stateParams.type) {
        console.debug('Type undefined');
        $defer.resolve([]);
      } else {
        console.debug('Processing type=' + $stateParams.type);
      }
      //Ajax request to backend resource
      ProcessService($stateParams.type).page(params.$params, function(response) {
        params.total(response.total);
        $defer.resolve(response.data);
      });
    }
  });

  function ProcessService(type) {
    console.debug('Finding service for type=' + type);
    switch(type) {
    case 'MIXING': 
      console.debug('Returning mixing process service. service=' + MixingProcessService);
      return MixingProcessService;
    case 'EXTRUSION': return ExtrusionProcessService;
    case 'PRINTING':return PrintingProcessService;
    case 'CUTTING': return CuttingProcessService;
    default:
      console.debug('No service returned');
    }
  }
});