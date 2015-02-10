'use strict';

describe('Service: PegawaiFactory', function () {

  // load the service's module
  beforeEach(module('belajarTestingAngularApp'));

  // instantiate service
  var PegawaiFactory;
  beforeEach(inject(function (_PegawaiFactory_) {
    PegawaiFactory = _PegawaiFactory_;
  }));

  it('should do something', function () {
    expect(!!PegawaiFactory).toBe(true);
  });

});
