import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeedcheckerComponent } from './speedchecker.component';
import { HttpClient } from '@angular/common/http';

describe('SpeedcheckerComponent', () => {
  let component: SpeedcheckerComponent;
  let fixture: ComponentFixture<SpeedcheckerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpeedcheckerComponent, HttpClient],
    }).compileComponents();

    fixture = TestBed.createComponent(SpeedcheckerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
