(function(angular) {
  'use strict';

    var app = angular.module('uigrid', ['ngTouch', 'ui.grid']);
    app.controller('RunController', ['ProductsService', '$scope', function (ProductsService, $scope) {
        $scope.gridOptions = {
            excludeProperties: '__metadata',
        };

        $scope.load = function () {
            ProductsService.readAll().then(function (response) {
                $scope.gridOptions.data = response.data;
            });
        }

        $scope.load();
    }]);

    (function() {

        angular.module('uigrid')
            .service('ProductsService', ['$http', ProductsService]);

        function ProductsService($http) {

            var self = this;
            var baseUrl = 'http://localhost:8080/api/';
            var objectName = 'runinstance';

            self.readAll = function () {
                return $http({
                    method: 'GET',
                    url: baseUrl + objectName
                }).then(function (response) {
                    return response;
                });
            };

            self.readOne = function (id) {
                return $http({
                    method: 'GET',
                    url: baseUrl + objectName + '/' + id
                }).then(function (response) {
                    return response;
                });
            };

            self.create = function (data) {
                return $http({
                    method: 'POST',
                    url: baseUrl + objectName,
                    data: data,
                    params: {
                        returnObject: true
                    }
                }).then(function (response) {
                    return response;
                });
            };

            self.update = function (id, data) {
                return $http({
                    method: 'PUT',
                    url: baseUrl + objectName + '/' + id,
                    data: data
                }).then(function (response) {
                    return response;
                });
            };

            self.delete = function (id) {
                return $http({
                    method: 'DELETE',
                    url: baseUrl + objectName + '/' + id
                });
            };
        }
    })();

})(window.angular);