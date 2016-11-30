(function(angular) {
  'use strict';
agGrid.initialiseAgGridWithAngular1(angular);

angular.module('app', ['services', 'agGrid'])
  .controller('RunController', ['loadInstances', function RunController(loadInstances) {
        var columnDefs = [
            {headerName: "Name", field: "name"}
        ];

        var instances = loadInstances.instances;

        this.gridOptions = {
                                columnDefs: columnDefs,
                                rowData: instances
                            };


        this.create = function create() {
            window.alert('Thanks!');
        };
  }]);
})(window.angular);