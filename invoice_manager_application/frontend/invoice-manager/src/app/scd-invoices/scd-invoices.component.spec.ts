import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScdInvoicesComponent } from './scd-invoices.component';

describe('ScdInvoicesComponent', () => {
  let component: ScdInvoicesComponent;
  let fixture: ComponentFixture<ScdInvoicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ScdInvoicesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScdInvoicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
