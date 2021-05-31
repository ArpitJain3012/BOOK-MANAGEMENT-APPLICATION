import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderdetailService } from '../service/orderdetail.service';

@Component({
  selector: 'app-orderdetail-form',
  templateUrl: './orderdetail-form.component.html',
  styleUrls: ['./orderdetail-form.component.css']
})
export class OrderdetailFormComponent implements OnInit {

  
  order_detail_Idfc: FormControl;
  quantityfc:FormControl;
  bookorder_idfc:FormControl;
  book_Idfc:FormControl;
 

  odForm:FormGroup;
  isEditing:boolean;

 

constructor(private orderdetailService : OrderdetailService, private router : Router,
  private activatedRoute : ActivatedRoute) { 

    
  this.order_detail_Idfc = new FormControl(null);
  this.quantityfc = new FormControl(null, [Validators.required, Validators.min(1),Validators.max(100)]);
  this.bookorder_idfc = new FormControl(null);
  this.book_Idfc = new FormControl(null);
  

  this.odForm = new FormGroup({


    order_detail_Id : this.order_detail_Idfc,
    quantity:this.quantityfc,
    bookorder_id : this.bookorder_idfc,
    book_Id : this.book_Idfc
   
   

    
  });

  this.isEditing = false;
 
  }

  ngOnInit(): void {
    let rid = this.activatedRoute.snapshot.params.rid;
    if (rid) {
      this.isEditing = true;
      this.orderdetailService.getById(rid).subscribe(
        (data) => this.odForm.setValue(data)
      );
    }
  } 
 
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.orderdetailService.update(this.odForm.value);
    } else {
      obr = this.orderdetailService.add(this.odForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/headcusts/orders")
    );
  }
}
