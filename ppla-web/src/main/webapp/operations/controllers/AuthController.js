define(['controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('AuthController', ['$scope', '$state', 'AuthService', 'PplaUserService',
    function($scope, $state, AuthService, PplaUserService) {

    $scope.principal = AuthService.get(function(principal) {
      if (principal.authenticated) {
        switch (principal.authorities[0].authority) {
        case 'ROLE_WAREHOUSE':
          $state.go('warehouse.identity');
          break;
        case 'ROLE_MIXER':
          $state.go('mixer.identity');
          break;
        case 'ROLE_EXTRUDER':
          $state.go('extruder.identity');
          break;
        case 'ROLE_PRINTER':
          $state.go('printer.identity');
          break;
        case 'ROLE_CUTTER':
          $state.go('cutter.identity');
          break;
        }
      }
    });

  }]);
});
