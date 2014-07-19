angular.module('ppla.controllers')

.controller('MaterialController', function($scope, MaterialService) {

  $scope.materials = MaterialService.get();
  $scope.materialType = 'raw';
  $scope.material = {};

  $scope.saveMaterial = function () {
    MaterialService.save({type: $scope.materialType}, $scope.material, function(saved) {
      switch($scope.materialType) {
      case 'raw':
        $scope.materials.rawMaterials.push(saved);
        break;
      case 'process':
        $scope.materials.procMaterials.push(saved);
        break;
      }
    });
  };
});