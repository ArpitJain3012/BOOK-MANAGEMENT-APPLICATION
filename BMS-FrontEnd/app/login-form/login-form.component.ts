import { Component,  OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  msg ='';
  userEmailfc : FormControl;
  passwordfc : FormControl;

  loginForm : FormGroup;

  constructor(private loginService : LoginService, private router : Router, private customerService:CustomerService,
    private activatedRoute : ActivatedRoute) {

      this.userEmailfc = new FormControl(null,[Validators.required,Validators.email]);
      this.passwordfc = new FormControl(null,[Validators.required,Validators.pattern("[a-zA-Z0-9]{8,14}")]);
      
      this.loginForm= new FormGroup ({
        email : this.userEmailfc,
        password : this.passwordfc,

      });

     };

  ngOnInit(): void {
    let lid = this.activatedRoute.snapshot.params.lid;
    if (lid) {
      this.loginService.singIn(this.loginForm.value).subscribe(
        
        (data) => this.loginForm.setValue(data)
      
      );
    }
  }

    handleSubmit(){
      this.loginService.singIn(this.loginForm.value).subscribe(
      (data) => {
        this.loginService.currentCustomer=data;
        console.log(this.loginService.currentCustomer);
        if(this.loginService.currentCustomer.customerId!=2){
          console.log(this.loginService.currentCustomer.customerId);
        // this.router.navigateByUrl("/uheader");
       }
        else{
          this.router.navigateByUrl("/headcusts/dashboard");
        }

      },
        (error)=>{
          this.msg= "Bad Credentials , Please enter valid email and password";
       });
    }

}
