/**
 * @ngdoc function
 * @name belajarTestingAngularApp.controller:BarangcontrollerCtrl
 * @description
 * # BarangcontrollerCtrl
 * Controller of the belajarTestingAngularApp
 */

(function() {
  'use strict';
  angular.module('belajarTestingAngularApp')
    .controller('BarangController', BarangController);

  BarangController.$inject = ['$location', 'BarangFactory'];

  function BarangController($location, BarangFactory) {
    var barang = this;

    barang.inputanBarang = {};
    barang.enable = true;
    barang.dataBarang = {};

    barang.namaBarang = 'rinso';

    barang.getRefreshBarang = function() {
      BarangFactory.getAllBarang().query({}, function(data) {
        barang.dataBarang = data;
      });
    };

    function refreshBarang() {
      BarangFactory.getAllBarang().query({}, function(data) {
        barang.dataBarang = data;
      });
    }

    refreshBarang();

    barang.clear = function() {
      barang.inputanBarang.idBarang = '';
      barang.inputanBarang.namaBarang = '';
      barang.inputanBarang.jumlahBarang = '';
      barang.inputanBarang.tanggalKadaluarsa = '';
      barang.enable = false;
    };

    barang.saveBarang = function(barang) {
      BarangFactory.saveBarang().query({}, barang).$promise.then(function() {
        refreshBarang();
      });
    };

    barang.editBarang = function(b) {
      barang.inputanBarang.idBarang = b.idBarang;
      barang.inputanBarang.namaBarang = b.namaBarang;
      barang.inputanBarang.jumlahBarang = b.jumlahBarang;
      barang.inputanBarang.tanggalKadaluarsa = b.tanggalKadaluarsa;
      barang.enable = true;
    };

    barang.updateBarang = function(barang) {
      BarangFactory.updateBarang().query({}, barang).$promise.then(function() {
        refreshBarang();
      });
    };

    barang.deleteBarang = function(b) {
      BarangFactory.deleteBarang(b.idBarang).query({}).$promise.then(function() {
        refreshBarang();
      });
    };

  }

})();
