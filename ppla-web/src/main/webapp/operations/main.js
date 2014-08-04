require.config({
  paths: {
    'angular':  '/lib/angular/angular',
    'jquery': 'http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min',
    'domReady': '/lib/require/domReady',
    'uiRouter': '/lib/angular/angular-ui-router.min',
    'ngResource': '/lib/angular/angular-resource.min',
    'ngTable': '/lib/angular-ngtable/ng-table.min',
    'bootstrap': '/lib/bootstrap-3.2.0/js/bootstrap.min',
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