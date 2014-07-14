angular.module('ppla.services', ['ngResource'])

.factory('SalesOrderService', function($resource) {
  return $resource('/salesorder/:trackingNo', {}, {
    page: {method: 'GET', isArray: false}
  });
})

.factory('OrderItemService', function($resource) {
  return $resource('/orderItem/:action/:id');
})

.factory('WorkOrderService', function($resource) {
  return $resource('/workOrder/:action/:orderItemId/:trackingNo', {}, {
    page: {method: 'GET', isArray: false},
    close: {method: 'POST', isArray: false, params: {action: 'close'}}
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