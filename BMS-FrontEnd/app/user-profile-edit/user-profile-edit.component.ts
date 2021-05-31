import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-user-profile-edit',
  templateUrl: './user-profile-edit.component.html',
  styleUrls: ['./user-profile-edit.component.css']
})
export class UserProfileEditComponent implements OnInit {

  msg="";
  customerIdfc : FormControl;
  emailfc:FormControl;
  fullNamefc : FormControl;
  passwordfc:FormControl;
  mobileNumberfc : FormControl;
  registerOnfc:FormControl;
  housenofc : FormControl;
  cityfc : FormControl;
  countryfc : FormControl; 
  pincodefc : FormControl;

  customerForm: FormGroup;

  

  constructor(private custService : CustomerService, private router : Router,private loginService : LoginService,
    private activatedRoute : ActivatedRoute) { 

      
    this.customerIdfc = new FormControl(null);
    this.emailfc = new FormControl(null, Validators.required);
    this.fullNamefc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.passwordfc= new FormControl('',[Validators.required,Validators.min(5), Validators.max(15)]);
    this.mobileNumberfc = new FormControl(null, [Validators.required, Validators.pattern("[1-9][0-9]{9}")]);
   
    this.registerOnfc = new FormControl(null);
    this.housenofc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.cityfc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.countryfc= new FormControl(null,[Validators.required]);
    this.pincodefc = new FormControl(null, [Validators.required, Validators.minLength(5),Validators.maxLength(6)]);

    this.customerForm= new FormGroup({
      customerId : this.customerIdfc,
      email : this.emailfc,
      fullName : this.fullNamefc,
     password:this.passwordfc,
      mobileNumber : this.mobileNumberfc,
      
      registerOn: this.registerOnfc,
      houseno : this.housenofc,
      city : this.cityfc,
      country : this.countryfc,
      pincode : this.pincodefc,

    });

    

  };

  ngOnInit(): void {
    // this.loginCustomerId=this.loginService.currentCustomer.customerId;
    let eid = this.activatedRoute.snapshot.params.eid;
    if (eid) {
      this.custService.getById(eid).subscribe(
        
        (data) =>{ 
          console.log(eid);
          this.customerForm.setValue( {
              customerId : data.customerId,
              email :data.email,
              fullName : data.fullName,
             password:data.password,
              mobileNumber :data.mobileNumber,
              registerOn:data.registerOn,
              houseno:data.am.houseno,
              city :data.am.city,
              country :data.am.country,
              pincode :data.am.pincode   
          });
        console.log(this.customerForm.value);
        }
      );
    }
  }

  
  handleSubmit() {
    let obr = null;
    let customer : Customer = {
      customerId : this.customerForm.value.customerId,
      email : this.customerForm.value.email,
      fullName : this.customerForm.value.fullName,
      password: this.customerForm.value.password,
      mobileNumber : this.customerForm.value.mobileNumber,
      registerOn: this.customerForm.value.registerOn,
     
      am: {
          houseno: this.customerForm.value.houseno,
          city : this.customerForm.value.city,
          country : this.customerForm.value.country,
          pincode : this.customerForm.value.pincode,
        }
      }

      obr = this.custService.update(customer);
  
    obr.subscribe(
      (data) => {this.msg="User Data Updated Successfully";
      this.router.navigateByUrl("/uheader/ucustomer/editCustomer/{{ this.customerId }}")}
    );
  }


}
