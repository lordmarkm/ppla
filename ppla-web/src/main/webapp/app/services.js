angular.module('ppla.services', ['ngResource'])

.factory('SalesOrderService', function($resource) {
  return $resource('/salesorder/:trackingNo', {}, {
    page: {method: 'GET', isArray: false}
  });
})

.factory('ProductService', function($resource) {
  return $resource('/product/:id', {}, {
    page: {method: 'GET', isArray: false}
  });
})

.factory('MaterialService', function($resource) {
  return $resource('/material/:type');
});