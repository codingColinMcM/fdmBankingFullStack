import { Component } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { ViewAccountsService } from './view-accounts.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-accounts',
  templateUrl: './View_Accounts.component.html',
  standalone: true,
  imports: [NgFor, NgIf]
})
export class ViewAccountsComponent {

  accounts: any[] = [];
  private customerId: number = 0;  

  constructor(
  private viewAccountsService: ViewAccountsService,
  private http: HttpClient,
  private activatedRoute: ActivatedRoute,
  private router: Router
  ) { }
  
  ngOnInit() {
    this.customerId = this.activatedRoute.snapshot.params['customerId'];
    this.loadAccounts(this.customerId);
  }
  
  loadAccounts(customerId: number) {
    this.viewAccountsService.loadCustomerWithAccountsTable(customerId).subscribe(
      (response: any) => {
        console.log('Account table loaded successfully', response);
		//response is a single customer object with an array of accounts
        this.accounts = response.accounts; 
      },
      (error: any) => {
        console.error('Error loading account table', error);
      }
    );
  }
  
  deleteAccount(accountId: number) {
    this.viewAccountsService.deleteAccount(accountId).subscribe(
	  (response: any) => {
        console.log('Account deleted successfully', response);
		this.loadAccounts(this.customerId);
      },
      (error: any) => {
        console.error('Error deleting account', error);
      }
	);
  }
  
  navigateToCreateAccount() {
    this.router.navigate(['/Create_Account', this.customerId]);
  }
  
  navigateToUpdateAccount(accountId: number) {
    this.router.navigate(['/Update_Account', accountId]);
  }
}
