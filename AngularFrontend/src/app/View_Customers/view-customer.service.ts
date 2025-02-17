import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewCustomerService {

  private apiUrl = 'http://localhost:8888/api/v1/customers'

  constructor(private http: HttpClient) {}
  
  loadCustomersTable(): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
	return this.http.get(this.apiUrl, { headers });
  }
  
  deleteCustomer(customerId: number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
	const deleteCustomerUrl = `${this.apiUrl}/${customerId}`;
	return this.http.delete(deleteCustomerUrl, { headers });
  }
}
