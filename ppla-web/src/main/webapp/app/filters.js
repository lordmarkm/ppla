angular.module('ppla.filters', [])

.filter('name', function() {
  return function(nameInfo) {
    return nameInfo ? nameInfo.givenName + ' ' + nameInfo.surname : '';
  };
});