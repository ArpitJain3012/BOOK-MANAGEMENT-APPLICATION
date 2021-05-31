import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orderdetail } from '../model/orderdetail';

@Injectable({
  providedIn: 'root'
})
export class OrderdetailService {
  odApi : string;

  constructor(private httpClient : HttpClient) {
    this.odApi = "http://localhost:8082/orders";
   }

   getAll() : Observable<Orderdetail[]>{
    return this.httpClient.get<Orderdetail[]>(this.odApi);
  }

  getById(rid : number) : Observable<Orderdetail> {
    return this.httpClient.get<Orderdetail>(`${this.odApi}/${rid}`);
  }

   deleteById(rid : number) : Observable<void> {
      return this.httpClient.delete<void>(`${this.odApi}/${rid}`);
   }

   add(review : Orderdetail) : Observable<Orderdetail> {
      return this.httpClient.post<Orderdetail>(this.odApi, review);
   }

   update(review : Orderdetail) : Observable<Orderdetail> {
      return this.httpClient.put<Orderdetail>(this.odApi, review);
   }
  
    }

