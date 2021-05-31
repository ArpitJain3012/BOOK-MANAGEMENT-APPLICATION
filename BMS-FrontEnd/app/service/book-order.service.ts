import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookOrder } from '../model/book-order';

@Injectable({
  providedIn: 'root'
})
export class BookOrderService {

  boApi: string;


  constructor(private httpClient: HttpClient) {
    
      this.boApi = "http://localhost:8082/bookorder";
   
    }
    getAll(): Observable<BookOrder[]> {
      return this.httpClient.get<BookOrder[]>(this.boApi);
    }
    getById(orderId: number): Observable<BookOrder> {
      return this.httpClient.get<BookOrder>(`${this.boApi}/${orderId}`);
    }
    getOrdersByCustomerId(cid: number): Observable<BookOrder[]> {
      return this.httpClient.get<BookOrder[]>(`${this.boApi}/${cid}/CustomerModel`);
    }
    deleteById(orderId: number): Observable<void> {
      return this.httpClient.delete<void>(`${this.boApi}/${orderId}`);
    }
  
    add(bookorder : BookOrder) : Observable<BookOrder>{
      return this.httpClient.post<BookOrder>(this.boApi,bookorder);
    }
    update(bookorder : BookOrder) : Observable<BookOrder>{
      return this.httpClient.put<BookOrder>(this.boApi,bookorder);

    

     }
    
   }
