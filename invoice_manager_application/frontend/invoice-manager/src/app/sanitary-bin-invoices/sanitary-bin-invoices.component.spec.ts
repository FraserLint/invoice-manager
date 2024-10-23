import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SanitaryBinInvoicesComponent } from './sanitary-bin-invoices.component';

describe('SanitaryBinInvoicesComponent', () => {
  let component: SanitaryBinInvoicesComponent;
  let fixture: ComponentFixture<SanitaryBinInvoicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SanitaryBinInvoicesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SanitaryBinInvoicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
