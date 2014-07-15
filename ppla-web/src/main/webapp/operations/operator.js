requirejs.config({
  baseUrl: '/',
  paths: {
    'angular': 'lib/angular/angular.min',
    'app': 'operations/app'
  },
  shim: {
    'angular': {
      exports: 'angular'
    }
  }
});

require([
  'app'
]);