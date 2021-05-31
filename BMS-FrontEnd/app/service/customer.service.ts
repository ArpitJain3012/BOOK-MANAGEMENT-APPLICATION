import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
custApi : string;
custApiEdit : string;
  constructor(private httpClient: HttpClient) {
    this.custApi = "http://localhost:8082/customers";
    this.custApiEdit="http://localhost:8082/customers/edit"
   }
   getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.custApi);
  }
  getById(cid: number): Observable<Customer> {
    return this.httpClient.get<Customer>(`${this.custApi}/${cid}`);
  }

  deleteById(cid: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.custApi}/${cid}`);
  }

  add(customer : Customer) : Observable<Customer>{
    console.log(customer);
    return this.httpClient.post<Customer>(this.custApi,customer);
  }
  update(customer : Customer) : Observable<Customer>{
    console.log(customer);
    return this.httpClient.put<Customer>(this.custApiEdit,customer);
  }
}
