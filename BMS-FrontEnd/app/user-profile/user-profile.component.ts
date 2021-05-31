import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  cust: Customer;
  err : string;
  customerForm: FormGroup;

  constructor(private custService : CustomerService, private loginService: LoginService,private activatedRoute : ActivatedRoute) { 
  }

  ngOnInit(): void {
    this.custService.getById(this.loginService.currentCustomer.customerId).subscribe(
      (data) => { this.cust= data; console.log(data);},
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }

}
