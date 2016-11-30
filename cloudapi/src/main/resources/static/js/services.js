(function(angular) {
  'use strict';
angular.module('services', [])
    .factory('loadInstances', ['$q', '$http', function($http) {
        var _deferred = $q.defer();

        var URL_PATTERN = 'http://localhost:8080/api/listallruninstance';
        var instances = {};

        $http.get(URL_PATTERN).success(function(data, status, headers, config) {
            _deferred.resolve(data);
        })
        .error(function(data, status, headers, config) {
            _deferred.reject("Error");
        });

        return {
            instances: function(){
                return _deferred.promise;
            }
        };
  }]);
})(window.angular);