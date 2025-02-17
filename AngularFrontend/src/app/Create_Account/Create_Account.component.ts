import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { CreateAccountService } from './create-account.service'; 
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './Create_Account.component.html',
})

export class CreateAccountComponent {
  
  public balance: number = 0;
  public accountType: string = "";
  public interestRate: number = 0;
  public nextCheckNumber: number = 0;
  private customerId: number = 0;
  
  constructor(
  private createAccountService: CreateAccountService,
  private http: HttpClient,
  private activatedRoute: ActivatedRoute, 
  private router: Router
  ) { }
  
  ngOnInit() {
    this.customerId = this.activatedRoute.snapshot.params['customerId'];
  }
  
  onSubmit(): void {

    const account = {
      "balance": this.balance,
      "accountType": this.accountType,
      "interestRate": this.interestRate || null,
      "nextCheckNumber": this.nextCheckNumber || null
    };	 
	  
	this.createAccountService.createAccount(this.customerId, account).subscribe(
      response => {
        console.log('Account created successfully', response);
		this.router.navigate(['/View_Accounts', this.customerId]);
      },
      error => {
        console.error('Error creating account', error);
      }
    );  
  }
}

