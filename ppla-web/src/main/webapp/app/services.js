angular.module('ppla.services', ['ngResource'])

.factory('SalesOrderService', function($resource) {
  return $resource('/salesorder');
})

.factory('ProductService', function($resource) {
  return $resource('/product/:id', {}, {
    page: {method: 'GET', isArray: false}
  });
});