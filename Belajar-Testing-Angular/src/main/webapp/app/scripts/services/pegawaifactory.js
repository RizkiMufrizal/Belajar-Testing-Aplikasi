'use strict';

/**
 * @ngdoc service
 * @name belajarTestingAngularApp.PegawaiFactory
 * @description
 * # PegawaiFactory
 * Factory in the belajarTestingAngularApp.
 */
angular.module('belajarTestingAngularApp')
  .factory('PegawaiFactory', function () {
    // Service logic
    // ...

    var meaningOfLife = 42;

    // Public API here
    return {
      someMethod: function () {
        return meaningOfLife;
      }
    };
  });
