import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  imageSrc = 'assets/pic.jpg'  
  imageAlt = 'pic'
  constructor() { }

  ngOnInit(): void {
  }

}
