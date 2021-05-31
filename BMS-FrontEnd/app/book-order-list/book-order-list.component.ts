import { Component, OnInit } from '@angular/core';
import { BookOrder } from '../model/book-order';
import { BookOrderService } from '../service/book-order.service';

@Component({
  selector: 'app-book-order-list',
  templateUrl: './book-order-list.component.html',
  styleUrls: ['./book-order-list.component.css']
})
export class BookOrderListComponent implements OnInit {

  bookorder: BookOrder[];
  err: string;
  constructor(private bookorderService: BookOrderService) { }

  ngOnInit(): void {
    this.bookorderService.getAll().subscribe(
      (data) => this.bookorder = data,
      (err) => {
        console.log(err);
        this.err = "sorry. unable to retrieve data"
      }
    );
  }
  delete(orderId: number) {
    if (confirm("Are you sure?")) {
      this.bookorderService.deleteById(orderId).subscribe(
        () => { this.bookorder.splice(this.bookorder.findIndex(bo => bo.orderId == orderId), 1) }
      );
    }
  }
}

