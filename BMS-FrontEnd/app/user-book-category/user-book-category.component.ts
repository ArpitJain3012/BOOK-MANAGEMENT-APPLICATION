import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../model/book';
import { Category } from '../model/category';
import { BookService } from '../service/book.service';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-user-book-category',
  templateUrl: './user-book-category.component.html',
  styleUrls: ['./user-book-category.component.css']
})
export class UserBookCategoryComponent implements OnInit {
  bookIdfc: FormControl;
  titlefc: FormControl;
  authorfc: FormControl;
  descriptionfc: FormControl;
  isbnfc: FormControl;
  pubDatefc: FormControl;
  lastUpDatefc: FormControl;
  pricefc: FormControl;
  categoryIdfc: FormControl;

  err: string;
  categoryId: number;
  books: Book[];
  bookForm: FormGroup;

  isEditing: boolean;

  constructor(private booksService: BookService, private router: Router,
    private activatedRoute: ActivatedRoute, private catservice: CategoryService) {

    this.bookIdfc = new FormControl(null);
    this.titlefc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.authorfc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.descriptionfc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.isbnfc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.pubDatefc = new FormControl(null, Validators.required);
    this.lastUpDatefc = new FormControl(null, Validators.required);
    this.pricefc = new FormControl(null, [Validators.required, Validators.min(100), Validators.max(5000)]);
    this.categoryIdfc = new FormControl(null);

    this.bookForm = new FormGroup({
      bookId: this.bookIdfc,
      title: this.titlefc,
      author: this.authorfc,
      description: this.descriptionfc,
      isbn: this.isbnfc,
      pubDate: this.pubDatefc,
      lastUpDate: this.lastUpDatefc,
      price: this.pricefc,
      categoryId: this.categoryIdfc

    });
    this.categoryId = null;
    // this.cat = [10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20];
    this.isEditing = false;
  }

  ngOnInit(): void {
    // console.log(this.catid);
    // this.booksService.getByCategoryId(this.catid).subscribe(
    //   (data) => { this.books = data; console.log(data); },
    //   (err) => {
    //     console.log(err);
    //     this.err = "sorry. unable to retrieve data"
    //   }
    // )
  }
  handleSubmit(){
    console.log(this.categoryId);
    this.booksService.getByCategoryId(this.categoryId).subscribe(
      (data) => { this.books = data;},
      (err) => {
        console.log(err);
        this.err = "sorry. unable to retrieve data"
      }
    );
  }

}
