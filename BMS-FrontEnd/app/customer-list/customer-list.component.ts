import { Component, OnInit } from '@angular/core';
import { Address } from '../model/address';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
cust : Customer[];
err : string;
address : Address;
  constructor(private custService : CustomerService) { }

  ngOnInit(): void {
    this.custService.getAll().subscribe(
      (data) => {console.log(this.address);this.cust= data},
      (err) => {console.log(err); this.err ="Sorry.unable to retrieve Customer data"}
    );
  }

  delete(cId : number){
    if(confirm("Are You Sure ?")){
      this.custService.deleteById(cId).subscribe(
        () => {this.cust.splice(this.cust.findIndex(e => e.customerId == cId),1)}
      );
    }
  }

}
