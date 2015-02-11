/**
 * @ngdoc service
 * @name belajarTestingAngularApp.BarangFactory
 * @description
 * # BarangFactory
 * Factory in the belajarTestingAngularApp.
 */

(function() {
  'use strict';
  angular.module('belajarTestingAngularApp')
    .factory('BarangFactory', BarangFactory);
  BarangFactory.$inject = ['$resource'];

  function BarangFactory($resource) {
    var barangFactory = this;

    barangFactory.getAllBarang = function() {
      return $resource('/Belajar-Testing-Angular/barang');
    };

    barangFactory.saveBarang = function() {
      return $resource('/Belajar-Testing-Angular/barang', {}, {
        query: {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          }
        }
      });
    };

    barangFactory.updateBarang = function() {
      return $resource('/Belajar-Testing-Angular/barang', {}, {
        query: {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json'
          }
        }
      });
    };

    barangFactory.deleteBarang = function(idBarang) {
      return $resource('/Belajar-Testing-Angular/barang/' + idBarang, {}, {
        query: {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json'
          }
        }
      });
    };

    return barangFactory;
  }

})();
