angular.module('ppla')

.config(function ($stateProvider) {
  $stateProvider.state('manual_wo_creation', {
    url: '/workorder_create',
    templateUrl: '/manage/modules/manual_wo_creation/view/manual_wo_creation.html',
    controller: 'ManualWorkOrderCreationController',
    resolve: {
      products: function (ProductService) {
        return ProductService.get({page: 1, count: 9999});
      }
    }
  });
});
