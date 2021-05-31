import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-headcusts',
  templateUrl: './headcusts.component.html',
  styleUrls: ['./headcusts.component.css']
})
export class HeadcustsComponent implements OnInit {

  constructor(private loginService : LoginService,private router : Router) { }

  ngOnInit(): void {
  }
  signOut(){
    this.loginService.currentCustomer=null;
    alert("Hey! You wanna sign out click me!!!");
    this.router.navigateByUrl("/login/signin");
  }
}
