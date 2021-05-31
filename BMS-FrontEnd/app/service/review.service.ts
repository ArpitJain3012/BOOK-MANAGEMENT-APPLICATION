import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Review } from '../model/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  revsApi : string;

  constructor(private httpClient : HttpClient) {
    this.revsApi = "http://localhost:8082/reviews";
   }

   getAll() : Observable<Review[]>{
    return this.httpClient.get<Review[]>(this.revsApi);
  }

  getById(rid : number) : Observable<Review> {
    return this.httpClient.get<Review>(`${this.revsApi}/${rid}`);
  }
  getReviewsByCustomerId(cid: number): Observable<Review[]> {
    return this.httpClient.get<Review[]>(`${this.revsApi}/${cid}/CustomerModel`);
  }
   deleteById(rid : number) : Observable<void> {
      return this.httpClient.delete<void>(`${this.revsApi}/${rid}`);
   }

   add(review : Review) : Observable<Review> {
      return this.httpClient.post<Review>(this.revsApi, review);
   }

   update(review : Review) : Observable<Review> {
      return this.httpClient.put<Review>(this.revsApi, review);
   }
  
    }

