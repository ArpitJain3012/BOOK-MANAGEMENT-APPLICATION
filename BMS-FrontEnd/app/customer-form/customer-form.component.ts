import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from '../model/address';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {
  custIdfc: FormControl;
  efc: FormControl;
  fnfc: FormControl;
  pfc: FormControl;
  mnfc: FormControl;
  rfc: FormControl;
  isEdit: boolean;
  housefc: FormControl;
  cityfc: FormControl;
  countryfc: FormControl;
  pinfc: FormControl;

  custForm: FormGroup;

  constructor(private custService: CustomerService, private router: Router,
    private activatedRoute: ActivatedRoute) {

    this.custIdfc = new FormControl(null, Validators.required);
    this.efc = new FormControl(null, Validators.email);
    this.fnfc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.pfc = new FormControl(null, [Validators.required, Validators.pattern("[a-zA-Z0-9 @_]{8,20}")]);
    this.mnfc = new FormControl(null, [Validators.required, Validators.pattern("[1-9][0-9]{9}")]);
    this.rfc = new FormControl(null, Validators.required);
    this.housefc = new FormControl(null, Validators.required);
    this.pinfc = new FormControl(null, Validators.required);
    this.cityfc = new FormControl(null, Validators.required);
    this.countryfc = new FormControl("INDIA", Validators.required);

    this.custForm = new FormGroup({
      customerId: this.custIdfc,
      email: this.efc,
      fullName: this.fnfc,
      password: this.pfc,
      mobileNumber: this.mnfc,
      registerOn: this.rfc,
      houseno: this.housefc,
      city: this.cityfc,
      country: this.countryfc,
      pincode: this.pinfc
    });

    this.isEdit = false;
  }

  ngOnInit(): void {
    let cid = this.activatedRoute.snapshot.params.cid;
    if (cid) {
      this.isEdit = true;
      this.custService.getById(cid).subscribe(
        (data) => {
          this.custForm.setValue({
            customerId: data.customerId,
            email: data.email,
            fullName: data.fullName,
            password: data.password,
            mobileNumber: data.mobileNumber,
            registerOn: data.registerOn,
            houseno: data.am.houseno,
            city: data.am.city,
            country: data.am.country,
            pincode: data.am.pincode
          });
          console.log(this.custForm.value);
        }
      );
    }
  }
  handleSubmit() {
    let obr = null;
    let customer: Customer = {
      customerId: this.custForm.value.customerId,
      email: this.custForm.value.email,
      fullName: this.custForm.value.fullName,
      password: this.custForm.value.password,
      mobileNumber: this.custForm.value.mobileNumber,
      registerOn: this.custForm.value.registerOn,
      am: {
        houseno: this.custForm.value.houseno,
        city: this.custForm.value.city,
        country: this.custForm.value.country,
        pincode: this.custForm.value.pincode
      }
    }
    if (this.isEdit) {
      obr = this.custService.update(customer);
      alert("Customer Updated");
    } else {
      obr = this.custService.add(customer);
      alert("Customer Added");
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/headcusts/custs")
    );

  }
}
