(function(angular) {
  'use strict';
angular.module('services', [])
  .factory('loadInstances', function() {
    var instances = ['USD', 'EUR', 'CNY'];

    return {
      instances: instances
    };
  });
})(window.angular);