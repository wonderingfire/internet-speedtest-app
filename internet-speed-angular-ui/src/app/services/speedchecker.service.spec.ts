import { TestBed } from '@angular/core/testing';

import { SpeedcheckerService } from './speedchecker.service';

describe('SpeedcheckerService', () => {
  let service: SpeedcheckerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SpeedcheckerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
