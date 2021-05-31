import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookOrder } from '../model/book-order';
import { BookOrderService } from '../service/book-order.service';

@Component({
  selector: 'app-user-book-order-form',
  templateUrl: './user-book-order-form.component.html',
  styleUrls: ['./user-book-order-form.component.css']
})
export class UserBookOrderFormComponent implements OnInit {

  orderIdfc: FormControl;
  custIdfc: FormControl;
  OrderDatefc: FormControl;
  OrderTotalfc: FormControl;
  statusfc: FormControl;
  paymentMethodfc: FormControl;
  recipientphonefc: FormControl;
  recipientNamefc: FormControl;
 
  bo:BookOrder;


  status: string[];
  bookorderForm: FormGroup;

  isEditing: boolean;



  paymentMethod: string[];

  constructor(private bookorderService: BookOrderService, private router: Router, private activatedRoute: ActivatedRoute) {

    this.orderIdfc = new FormControl(null);
    this.custIdfc = new FormControl(null);
    this.OrderDatefc = new FormControl(null, Validators.required);
    this.OrderTotalfc = new FormControl(null, [Validators.required, Validators.min(1)]);
    this.statusfc = new FormControl("Placed", Validators.required);
    this.paymentMethodfc = new FormControl(null);
    this.recipientphonefc = new FormControl(null, [Validators.required, Validators.pattern("[1-9][0-9]{9}")]);
    this.recipientNamefc = new FormControl(null, [Validators.required, Validators.minLength(3)]);



    this.bookorderForm = new FormGroup({
      orderId: this.orderIdfc,
      custId: this.custIdfc,
      orderDate: this.OrderDatefc,
      orderTotal: this.OrderTotalfc,
      status: this.statusfc,
      paymentMethod: this.paymentMethodfc,
      recipientphone: this.recipientphonefc,
      recipientName: this.recipientNamefc



    });

    this.isEditing = false;
  }



  ngOnInit(): void {
    let orderId = this.activatedRoute.snapshot.params.orderId;
    if (orderId) {
      this.isEditing = true;
      this.bookorderService.getById(orderId).subscribe(
        (data) => { console.log(data.orderDate); this.bookorderForm.setValue(data); }
      );
    }
  }

  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.bookorderService.update(this.bookorderForm.value);
    } else {
      obr = this.bookorderService.add(this.bookorderForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/uheader/ubookorder")
    );
  }



}
