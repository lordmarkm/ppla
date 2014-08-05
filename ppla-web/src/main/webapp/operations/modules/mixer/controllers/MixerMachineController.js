define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('MixerMachineController', ['$scope', 'MachineService',
    function($scope, MachineService) {

    $scope.machines = MachineService.query({type:'MIXING'});

  }]);
});
