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

    $scope.addData = function() {
          ProductsService.create($scope.name).then(function (response) {
              $scope.gridOptions.data = response.data;
          });
    };

    $scope.load();
}]);
