import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {
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
  delete(bookId: number) {
    if (confirm("Are you sure?")) {
      this.booksService.deleteById(bookId).subscribe(
        () => { this.books.splice(this.books.findIndex(b => b.bookId == bookId), 1) }
      );
    }
  }
}

