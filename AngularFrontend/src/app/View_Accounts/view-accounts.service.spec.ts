import { TestBed } from '@angular/core/testing';

import { ViewAccountsService } from './view-accounts.service';

describe('ViewAccountsService', () => {
  let service: ViewAccountsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewAccountsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
