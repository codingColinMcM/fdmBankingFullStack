import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CreateAccountComponent } from './Create_Account/Create_Account.component';
import { CreateCustomerComponent } from './Create_Customer/Create_Customer.component';
import { HomeComponent } from './home/home.component';
import { UpdateAccountComponent } from './Update_Account/Update_Account.component';
import { UpdateCustomerComponent } from './Update_Customer/Update_Customer.component';
import { ViewAccountsComponent } from './View_Accounts/View_Accounts.component';
import { ViewCustomersComponent } from './View_Customers/View_Customers.component';

export const routes: Routes = [ 
  { "path": '', "component": HomeComponent }, 
  { "path": 'Create_Account/:customerId', "component": CreateAccountComponent },
  { "path": 'Create_Customer', "component": CreateCustomerComponent },
  { "path": 'Update_Account/:accountId', "component": UpdateAccountComponent },
  { "path": 'Update_Customer/:customerId', component: UpdateCustomerComponent },
  { "path": 'View_Accounts/:customerId', "component": ViewAccountsComponent },
  { "path": 'View_Customers', "component": ViewCustomersComponent },
  { "path": '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
