define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('AuthController', ['$scope', '$state', 'AuthService', 'PplaUserService',
    function($scope, $state, AuthService, PplaUserService) {

    $scope.principal = AuthService.get(function(principal) {
      if (principal.authenticated) {
        $scope.profile = PplaUserService.get({username: principal.principal.username}, function (pplaUser) {
          if (!pplaUser || !pplaUser.id) {
            console.debug('No profile. redirecting to profile page.');
            $state.go('profile', {msg:'profile_required'});
          } else {
            console.debug('Profile found: ' + JSON.stringify($scope.profile));
          }
        });
      }
    });

  }]);
});
