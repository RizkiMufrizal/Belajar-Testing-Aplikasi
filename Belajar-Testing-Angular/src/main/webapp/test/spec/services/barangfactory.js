'use strict';

describe('Service: BarangFactory', function() {

  // Load Module
  beforeEach(module('belajarTestingAngularApp'));

  // instantiate service
  var BarangFactory;

  beforeEach(inject(function(_BarangFactory_) {
    BarangFactory = _BarangFactory_;
  }));

  it('should do something', function() {
    expect(!!BarangFactory).toBe(true);
  });

});
