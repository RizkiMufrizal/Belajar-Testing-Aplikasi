'use strict';

describe('Controller: Pegawaicontroller', function() {

  // Load Module Terlebih dahulu
  beforeEach(module('belajarTestingAngularApp'));

  var PegawaiController; // buat variabel baru

  // Initialize controller
  beforeEach(inject(function($controller) {
    PegawaiController = $controller('PegawaiController', {});
  }));

  it('should attach a list of awesomeThings to the scope', function() {
    expect(PegawaiController.nama).toBe('rizki'); //test kesamaan, harusnya sama
    expect(PegawaiController.nama.length).toBe(5); // harusnya panjangnya 5
  });
});
