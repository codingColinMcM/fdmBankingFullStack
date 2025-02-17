import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { ViewCustomerService } from './view-customer.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customers',
  templateUrl: './View_Customers.component.html',
  standalone: true,
  imports: [NgFor]
})
export class ViewCustomersComponent {

  customers: any[] = [];  

  constructor(
  private viewCustomerService: ViewCustomerService,
  private http: HttpClient,
  private router: Router
  ) { }
  
  ngOnInit() {
    this.loadCustomers();
  }
  
  loadCustomers() {
    this.viewCustomerService.loadCustomersTable().subscribe(
      (response: any) => {
        console.log('Customer table loaded successfully', response);
        this.customers = response; 
      },
      (error: any) => {
        console.error('Error loading customer table', error);
      }
    );
  }
  
  deleteCustomer(customerId: number) {
    this.viewCustomerService.deleteCustomer(customerId).subscribe(
	  (response: any) => {
        console.log('Customer deleted successfully', response);
		this.loadCustomers();
      },
      (error: any) => {
        console.error('Error deleting customer', error);
      }
	);
  }
  
  navigateToViewCustomerAccounts(customerId: number) {
    this.router.navigate(['/View_Accounts', customerId]);
  }
  
  navigateToCreateCustomer() {
    this.router.navigate(['/Create_Customer']);
  }
  
  navigateToUpdateCustomer(customerId: number) {
    this.router.navigate(['/Update_Customer', customerId]);
  }
}