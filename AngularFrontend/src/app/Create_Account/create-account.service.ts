import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateAccountService {

  private apiUrl = 'http://localhost:8888/api/v1/customers/single-account'; 

  constructor(private http: HttpClient) {}

  createAccount(customerId: number, account: any): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const createAccountUrl = `${this.apiUrl}/${customerId}`; 
    return this.http.put(createAccountUrl, account, { headers });
  }
}