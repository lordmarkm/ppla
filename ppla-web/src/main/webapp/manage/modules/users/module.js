angular.module('ppla')

.config(function ($stateProvider, $urlRouterProvider) {
  $stateProvider.state('users', {
    url: '/users',
    templateUrl: 'manage/modules/users/view/users.html',
    abstract: true,
    controller: 'UserManagementController'
  })
  .state('users.list', {
    url: '',
    templateUrl: 'modules/users/view/list_ngtable.html'
  })
  .state('users.edit', {
    url: '/edit',
    templateUrl: 'modules/users/view/edit.html'
  });
});
