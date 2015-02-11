/**
 * @ngdoc overview
 * @name webappApp
 * @description
 * # BelajarTestingAngular
 *
 * Main module of the application.
 */

(function() {
  'use strict';
  angular
    .module('belajarTestingAngularApp', [
      'ngAnimate',
      'ngAria',
      'ngCookies',
      'ngMessages',
      'ngResource',
      'ngRoute',
      'ngSanitize',
      'ngTouch',
      'ui.router',
      'ngBootbox'
      ])
    .config(function($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/Home');

      $stateProvider
        .state('Home', {
          url: '/Home',
          templateUrl: 'views/home.html',
          controller: 'BarangController',
          controllerAs: 'barang'
        });
    });
})();
