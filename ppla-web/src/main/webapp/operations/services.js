define(['angular'], function(angular) {
  'use strict';

  angular.module('app.services', ['ngResource'])

  .factory('AuthService', function($resource) {
    return $resource('../auth');
  })
  .factory('SalesOrderService', function($resource) {
    return $resource('../salesorder/:trackingNo', {}, {
      page: {method: 'GET', isArray: false}
    });
  })
  .factory('OrderItemService', function($resource) {
    return $resource('../orderItem/:action/:id');
  })
  .factory('WorkOrderService', function($resource) {
    return $resource('../workOrder/:action/:orderItemId/:trackingNo', {}, {
      page: {method: 'GET', isArray: false},
      close: {method: 'POST', isArray: false, params: {action: 'close'}},
      findByTag: {method: 'GET', isArray: false, params: {action: 'tag'}}
    });
  })
  .factory('ProductService', function($resource) {
    return $resource('../product/:id', {}, {
      page: {method: 'GET', isArray: false}
    });
  })
  .factory('MaterialService', function($resource) {
    return $resource('../material/:type/:source');
  })
  .factory('WoMaterialService', function($resource) {
    return $resource('../womaterials/:trackingNos/:source');
  })
  .factory('ProcessService', function($resource) {
    return $resource('../process');
  })
  .factory('WarehouseProcessService', function($resource) {
    return $resource('../warehouse');
  })
  .factory('MixingProcessService', function($resource) {
    return $resource('../mixing/:action/:id');
  })
  .factory('ExtrusionProcessService', function($resource) {
    return $resource('../extrusion/:action/:id');
  })
  .factory('PrintingProcessService', function($resource) {
    return $resource('../printing/:action/:id');
  })
  .factory('CuttingProcessService', function($resource) {
    return $resource('../cutting/:action/:id');
  })
  .factory('PplaUserService', function($resource) {
    return $resource('../user');
  })
  .factory('MachineService', function($resource) {
    return $resource('../machine/:type');
  })
  .factory('ProcessMaterialStackService', function($resource) {
    return $resource('../stack/:tag')
  });

});