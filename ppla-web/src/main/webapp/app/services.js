angular.module('ppla.services', ['ngResource'])

.factory('SalesOrderService', function($resource) {
  return $resource('/salesorder');
});