import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { ScdInvoicesComponent } from './scd-invoices/scd-invoices.component';
import { SanitaryBinInvoicesComponent } from './sanitary-bin-invoices/sanitary-bin-invoices.component';
import {MatAnchor} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    ScdInvoicesComponent,
    SanitaryBinInvoicesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatAnchor
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
