import { Component, OnInit } from '@angular/core';
import { BookOrder } from '../model/book-order';
import { Customer } from '../model/customer';
import { BookOrderService } from '../service/book-order.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-user-book-order-list',
  templateUrl: './user-book-order-list.component.html',
  styleUrls: ['./user-book-order-list.component.css']
})
export class UserBookOrderListComponent implements OnInit {

  bookorder: BookOrder[];
  err: string;
  custid:number;

  constructor(private bookorderService: BookOrderService,private loginService : LoginService) {
    
   }

  ngOnInit(): void {
    console.log(this.loginService.currentCustomer.customerId);
    this.bookorderService.getOrdersByCustomerId(this.loginService.currentCustomer.customerId).subscribe(
      (data) =>{ this.bookorder = data;console.log(data);},
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
