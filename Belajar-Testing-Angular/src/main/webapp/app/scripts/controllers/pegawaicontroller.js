/**
 * @ngdoc function
 * @name belajarTestingAngularApp.controller:PegawaicontrollerCtrl
 * @description
 * # PegawaicontrollerCtrl
 * Controller of the belajarTestingAngularApp
 */

(function() {
  'use strict';
  angular.module('belajarTestingAngularApp')
    .controller('PegawaiController', PegawaiController);

  PegawaiController.$inject = ['$location'];

  function PegawaiController($location) {
    var pegawai = this;

    pegawai.nama = 'rizki';
  }

})();
