define(['/operations/controllers/module.js'], function (controllers) {
  'use strict';
  controllers.controller('ProfileController', ['$scope', '$state', 'AuthService', 'PplaUserService',
    function($scope, $state, AuthService, PplaUserService) {

    $scope.params = $state.params;
    $scope.profile = {properName: {}};
    AuthService.get(function(principal) {
      $scope.principal = principal;
      if (principal.authenticated) {
        $scope.profile = PplaUserService.get({username: principal.principal.username});
      }
    });

    $scope.saveProfile = function () {
      PplaUserService.save($scope.profile, function(profile) {
        $scope.profile = profile;
        alert('Profile saved successfully.');
      });
    };

  }]);
});
