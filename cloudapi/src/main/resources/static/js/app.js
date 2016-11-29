(function(angular) {
  'use strict';
angular.module('app', ['services'])
  .controller('RunController', ['loadInstances', function RunController(loadInstances) {
    this.instances = loadInstances.instances;

    this.create = function create() {
        window.alert('Thanks!');
    };

  }]);
})(window.angular);