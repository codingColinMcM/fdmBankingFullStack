import { Component } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { CreateCustomerService } from './create-customer.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-customer',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './Create_Customer.component.html',
})
export class CreateCustomerComponent{

  public customerType: string = "";
  public name: string = "";
  public streetNumber: string = "";
  public postalCode: string = "";
  
  constructor(
  private createCustomerService: CreateCustomerService,
  private http: HttpClient,
  private router: Router
  ) { }  

  onSubmit(): void {
  
    const customer = {
      "customerType": this.customerType,
      "name": this.name,
	  "address": {
        "streetNumber": this.streetNumber,
        "postalCode": this.postalCode,
	  },
	  "accountDTOs": []
    };	
	  
	this.createCustomerService.createCustomer(customer).subscribe(
      response => {
	    this.router.navigate(['/View_Customers']);
        console.log('Customer created successfully', response);
      },
      error => {
        console.error('Error creating customer', error);
      }
    );  
  }
}

