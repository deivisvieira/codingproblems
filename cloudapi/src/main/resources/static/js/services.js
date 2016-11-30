(function(angular) {
  'use strict';
angular.module('services', [])
  .factory('loadInstances', ['$http', function($http) {
    var URL_PATTERN = 'http://localhost:8080/api/listallruninstance';
    var instances = {};

    var refresh = function() {
      return $http.get(URL_PATTERN).then(function(response) {
        instances = response.data;
      });
    };

    refresh();

    return {
      instances: instances
    };
  }]);
})(window.angular);