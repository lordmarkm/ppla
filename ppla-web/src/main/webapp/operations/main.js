require.config({
  paths: {
    'angular':  '/lib/angular/angular',
    'domReady': '/lib/require/domReady',
    'uiRouter': '/lib/angular/angular-ui-router.min',
    'ngResource': '/lib/angular/angular-resource.min',
    'ngTable': '/lib/angular-ngtable/ng-table.min',
    'op-controllers': '/operations/controllers/op-controllers'
  },
  shim: {
    'angular': {
      exports: 'angular'
    },
    'uiRouter':{
      deps: ['angular']
    },
    'ngResource': {
      deps: ['angular']
    },
    'ngTable': {
      deps: ['angular']
    }
  },
  deps: [
    '/operations/bootstrap.js'
  ]
});