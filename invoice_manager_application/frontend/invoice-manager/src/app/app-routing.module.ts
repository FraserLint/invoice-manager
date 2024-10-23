import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ScdInvoicesComponent } from './scd-invoices/scd-invoices.component';
import { SanitaryBinInvoicesComponent } from './sanitary-bin-invoices/sanitary-bin-invoices.component';

const routes: Routes = [
  { path: '', redirectTo: '/scd-invoices', pathMatch: 'full' },  // default route
  { path: 'scd-invoices', component: ScdInvoicesComponent },
  { path: 'sanitary-bin-invoices', component: SanitaryBinInvoicesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
