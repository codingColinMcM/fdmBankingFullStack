import { Component } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { UpdateCustomerService } from './update-customer.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router} from '@angular/router'; 

@Component({
  selector: 'app-update-customer',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './Update_Customer.component.html'
})
export class UpdateCustomerComponent { 

  public name: string = "";
  public streetNumber: string = "";
  public postalCode: string = "";
  private customerId: number = 0;
  
  constructor(
  private updateCustomerService: UpdateCustomerService,
  private http: HttpClient,
  private activatedRoute: ActivatedRoute,
  private router: Router  
  ) { } 
  
  ngOnInit() {
    this.customerId = this.activatedRoute.snapshot.params['customerId'];
  }
  
  onSubmit(): void {
  
    const customer = {
      "name": this.name,
	  "address": {
        "streetNumber": this.streetNumber,
        "postalCode": this.postalCode,
	  },
    };	
	  
	this.updateCustomerService.updateCustomer(this.customerId, customer).subscribe(
      response => {
        console.log('Customer updated successfully', response);
		this.router.navigate(['/View_Customers']);
      },
      error => {
        console.error('Error updating customer', error);
      }
    );
	  
  }

}
