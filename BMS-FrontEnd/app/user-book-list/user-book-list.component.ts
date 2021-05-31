import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-user-book-list',
  templateUrl: './user-book-list.component.html',
  styleUrls: ['./user-book-list.component.css']
})
export class UserBookListComponent implements OnInit {

  books: Book[];
  err: string;
  constructor(private booksService: BookService) { }

  ngOnInit(): void {
    this.booksService.getAll().subscribe(
      (data) => this.books = data,
      (err) => {
        console.log(err);
        this.err = "sorry. unable to retrieve data"
      }
    );
  }
  

}
