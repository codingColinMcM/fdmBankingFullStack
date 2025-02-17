import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { UpdateAccountService } from './update-account.service'; 
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router} from '@angular/router'; 

@Component({
  selector: 'app-update-Account',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './Update_Account.component.html',
})
export class UpdateAccountComponent {

  public balance: number = 0;
  public accountType: string = "";
  public interestRate: number = 0;
  public nextCheckNumber: number = 0;
  private accountId: number = 0;
  private customerId: number = 0;
  
  constructor(
  private updateAccountService: UpdateAccountService,
  private http: HttpClient,
  private activatedRoute: ActivatedRoute,
  private router: Router  
  ) { }
  
  ngOnInit() {
    this.accountId = this.activatedRoute.snapshot.params['accountId'];
	this.updateAccountService.getCustomerId(this.accountId).subscribe(
	  (response: any) => {
        console.log('Account table loaded successfully', response);
        this.customerId = response.customer.customerId;; 
      },
      (error: any) => {
        console.error('Error loading account table', error);
      }
	)
  }
  
  onSubmit(): void {

    const account = {
      "balance": this.balance,
      "accountType": this.accountType,
      "interestRate": this.interestRate || null,
      "nextCheckNumber": this.nextCheckNumber || null
    };	 
	  
	this.updateAccountService.updateAccount(this.accountId, account).subscribe(
      response => {
        console.log('Account updated successfully', response);
		this.router.navigate(['/View_Accounts', this.customerId]);
      },
      error => {
        console.error('Error creating account', error);
      }
    );  
  }
}
