import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateAccountService {

  private apiUrl = 'http://localhost:8888/api/v1/customers'; 
  

  constructor(private http: HttpClient) {}

  updateAccount(accountId: number, accountUpdate: any): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
	const updateAccountUrl = `${this.apiUrl}/update-account/${accountId}`;  
    return this.http.put(updateAccountUrl, accountUpdate, { headers });
  }
  
  getCustomerId(accountId: number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
	const getAccountUrl = `${this.apiUrl}/accounts/${accountId}`;  
    return this.http.get(getAccountUrl, { headers });
  }
}
