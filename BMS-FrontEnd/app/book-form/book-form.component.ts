import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
  bookIdfc : FormControl ;
  titlefc : FormControl ;
  authorfc : FormControl;
  descriptionfc : FormControl;
  isbnfc : FormControl ;
  pubDatefc : FormControl;
  lastUpDatefc : FormControl;
  pricefc : FormControl;
  categoryIdfc : FormControl;

  bookForm : FormGroup;

  isEditing: boolean;

  constructor(private booksService: BookService, private router: Router, private activatedRoute: ActivatedRoute) {

    this.bookIdfc= new FormControl(null) ;
    this.titlefc = new FormControl (null, [Validators.required, Validators.minLength(3)]) ;
    this.authorfc = new FormControl (null, [Validators.required, Validators.minLength(3)]);
    this.descriptionfc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.isbnfc = new FormControl(null, [Validators.required, Validators.minLength(3)]) ;
    this.pubDatefc = new FormControl(null, Validators.required);
    this. lastUpDatefc = new FormControl(null, Validators.required);
    this. pricefc =new FormControl(null, [Validators.required, Validators.min(100), Validators.max(5000)]);
    this.categoryIdfc = new FormControl(null);

    this.bookForm = new FormGroup({
      bookId : this.bookIdfc,
      title: this.titlefc,
      author : this.authorfc,
      description : this.descriptionfc,
      isbn : this.isbnfc,
      pubDate : this.pubDatefc,
      lastUpDate : this.lastUpDatefc,
      price : this.pricefc,
      categoryId : this.categoryIdfc

    });

    this.isEditing = false;
  }

   

  ngOnInit(): void {
    let bookId = this.activatedRoute.snapshot.params.bookId;
    if (bookId) {
      this.isEditing = true;
      this.booksService.getById(bookId).subscribe(
        (data) => this.bookForm.setValue(data)
      );
    }
  }

    handleSubmit() {
      let obr =null;
      if(this.isEditing){
        obr=this.booksService.update(this.bookForm.value);
      }else{
        obr=this.booksService.add(this.bookForm.value);
      }
      obr.subscribe(
        (data) =>this.router.navigateByUrl("/headcusts/books")
      );
    }
     

  

  }

