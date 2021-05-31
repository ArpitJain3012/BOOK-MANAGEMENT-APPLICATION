import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  categoryApi: string;
  constructor(private httpClient: HttpClient) {
      this.categoryApi = "http://localhost:8082/category";
    }
    getAll(): Observable<Category[]> {
      return this.httpClient.get<Category[]>(this.categoryApi);
    }
    getById(categoryId: number): Observable<Category> {
      return this.httpClient.get<Category>(`${this.categoryApi}/${categoryId}`);
    }
  
    deleteById(categoryId: number): Observable<void> {
      return this.httpClient.delete<void>(`${this.categoryApi}/${categoryId}`);
    }
  
    add(category : Category) : Observable<Category>{
      return this.httpClient.post<Category>(this.categoryApi,category);
    }
    update(category : Category) : Observable<Category>{
      return this.httpClient.put<Category>(this.categoryApi,category);
    
   }
}
