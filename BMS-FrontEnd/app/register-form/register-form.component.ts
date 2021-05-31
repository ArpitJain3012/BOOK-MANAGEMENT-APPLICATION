import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  msg ='';
  successfulMsg="";
  userIdfc : FormControl;
  userEmailfc : FormControl;
  rolefc:FormControl;
  passwordfc : FormControl;
  customerIdfc :  FormControl; 

  loginForm : FormGroup;

  constructor(private loginService : LoginService, private router : Router,
    private activatedRoute : ActivatedRoute) {
      this.userIdfc = new FormControl(null);
      this.userEmailfc = new FormControl(null, Validators.email);
      this.rolefc = new FormControl("customer" , Validators.required);
      this.passwordfc = new FormControl(null, [Validators.pattern("[a-zA-Z0-9]{8,14}")]);
      this.customerIdfc = new FormControl(null , Validators.required);
      
      this.loginForm= new FormGroup ({
        userId: this.userIdfc,
        email : this.userEmailfc,
        password : this.passwordfc,
        role : this.rolefc,
        customerId : this.customerIdfc

      });

     };

  ngOnInit(): void {
    let lid = this.activatedRoute.snapshot.params.lid;
    if (lid) {
      this.loginService.add(lid).subscribe(
        (data) => this.loginForm.setValue(data)
      );
    }
  }

    handleSubmit(){
      let obr =null;
      obr=this.loginService.add(this.loginForm.value);
      obr.subscribe(
        (data) => {this.router.navigateByUrl("/ulogin/usignin");
          alert("User register successfully");
        },
        (error)=>{
          this.msg= "Bad Credentials , Please enter valid details";
       }
        
      );
    }


}





