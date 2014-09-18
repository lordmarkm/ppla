angular.module('ppla.services', ['ngResource'])

.factory('PplaUserService', function($resource) {
  return $resource('/user/:action', {}, {
    page: {method: 'GET', isArray: false}
  });
})

.factory('AuthService', function($resource) {
  return $resource('/auth');
})

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
})

.factory('ProcessService', function($resource) {
  return $resource('/process');
})

.factory('MachineService', function($resource) {
  return $resource('/machine/:type/:id');
})
.factory('MixingProcessService', function($resource) {
  return $resource('/mixing/:action/:id', {}, {
    page: {method: 'GET', isArray: false}
  });
})
.factory('ExtrusionProcessService', function($resource) {
  return $resource('/extrusion/:action/:id', {}, {
    page: {method: 'GET', isArray: false}
  });
})
.factory('PrintingProcessService', function($resource) {
  return $resource('/printing/:action/:id', {}, {
    page: {method: 'GET', isArray: false}
  });
})
.factory('CuttingProcessService', function($resource) {
  return $resource('/cutting/:action/:id', {}, {
    page: {method: 'GET', isArray: false}
  });
});