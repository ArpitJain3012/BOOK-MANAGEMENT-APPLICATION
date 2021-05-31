import { Component, OnInit } from '@angular/core';
import { Orderdetail } from '../model/orderdetail';
import { OrderdetailService } from '../service/orderdetail.service';

@Component({
  selector: 'app-orderdetail-list',
  templateUrl: './orderdetail-list.component.html',
  styleUrls: ['./orderdetail-list.component.css']
})
export class OrderdetailListComponent implements OnInit {

  
  orderdetail: Orderdetail[];
  err : string;
  
  constructor(private orderdetailService : OrderdetailService) { }
  ngOnInit(): void {
    this.orderdetailService.getAll().subscribe(
      (data) => this.orderdetail = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }
  delete(empId: number) {
    if (confirm("Are you sure?")) {
      this.orderdetailService.deleteById(empId).subscribe(
        () => { this.orderdetail.splice(this.orderdetail.findIndex(e => e.order_detail_Id == empId), 1) }
      );
    }
  }

}
