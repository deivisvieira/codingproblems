(function(angular) {
  'use strict';
agGrid.initialiseAgGridWithAngular1(angular);
angular.module('app', ['services', 'agGrid'])
  .controller('RunController', ['loadInstances', function RunController(loadInstances) {
    this.instances = loadInstances.instances;

    this.create = function create() {
        window.alert('Thanks!');
    };

  }]);
})(window.angular);