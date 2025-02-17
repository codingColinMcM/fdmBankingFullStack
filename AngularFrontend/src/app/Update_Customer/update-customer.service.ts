import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateCustomerService {

  private apiUrl = 'http://localhost:8888/api/v1/customers';

  constructor(private http: HttpClient) { }

  updateCustomer(customerId: number, customerUpdate: any): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const updateCustomerUrl = `${this.apiUrl}/${customerId}`;  
    return this.http.put(updateCustomerUrl, customerUpdate, { headers });
  }
}