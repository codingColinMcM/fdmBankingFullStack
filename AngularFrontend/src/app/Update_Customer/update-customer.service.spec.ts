import { TestBed } from '@angular/core/testing';

import { UpdateCustomerService } from './update-customer.service';

describe('UpdateCustomerService', () => {
  let service: UpdateCustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateCustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
