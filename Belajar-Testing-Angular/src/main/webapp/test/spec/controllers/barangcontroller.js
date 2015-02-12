'use strict';

describe('Controller: BarangController', function() {

  // Load Module Terlebih dahulu
  beforeEach(module('belajarTestingAngularApp'));

  var BarangController; // buat variabel baru

  // Initialize controller
  beforeEach(inject(function($controller) {
    BarangController = $controller('BarangController', {});
  }));

  it('should attach a list of awesomeThings to the scope', function() {
    expect(BarangController.enable).toBe(true);
  });
});
