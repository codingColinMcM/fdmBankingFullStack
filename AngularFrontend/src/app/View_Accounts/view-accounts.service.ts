import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewAccountsService {

  private apiUrl = 'http://localhost:8888/api/v1/customers'

  constructor(private http: HttpClient) {}
  
  loadCustomerWithAccountsTable(customerId: number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const updateCustomerUrl = `${this.apiUrl}/${customerId}`;  
    return this.http.get(updateCustomerUrl, { headers });
  }
  
  deleteAccount(accountId: number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
	const deleteAccountUrl = `${this.apiUrl}/accounts/${accountId}`;
	return this.http.delete(deleteAccountUrl, { headers });
  }
}