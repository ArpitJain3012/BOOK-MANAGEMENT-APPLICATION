import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/book';


@Injectable({
  providedIn: 'root'
})
export class BookService {
  booksApi: string;
  // categoryApi: string;

  constructor(private httpClient: HttpClient) {

    this.booksApi = "http://localhost:8082/books";
    //this.categoryApi = "http://localhost:8082/category";
  }
  getAll(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(this.booksApi);
  }
  getById(bookId: number): Observable<Book> {
    return this.httpClient.get<Book>(`${this.booksApi}/${bookId}`);
  }

  deleteById(bookId: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.booksApi}/${bookId}`);
  }

  add(book: Book): Observable<Book> {
    return this.httpClient.post<Book>(this.booksApi, book);
  }
  update(book: Book): Observable<Book> {
    return this.httpClient.put<Book>(this.booksApi, book);
  }


  getByCategoryId(catId: number): Observable<Book[]> {
    return this.httpClient.get<Book[]>(`${this.booksApi}/${catId}/CategoryModel`);
  }

}
