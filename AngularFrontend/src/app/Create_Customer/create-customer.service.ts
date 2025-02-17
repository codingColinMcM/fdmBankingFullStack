import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateCustomerService {

  private apiUrl = 'http://localhost:8888/api/v1/customers';

  constructor(private http: HttpClient) { }

  createCustomer(customer: any): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.apiUrl, customer, { headers });
  }
}