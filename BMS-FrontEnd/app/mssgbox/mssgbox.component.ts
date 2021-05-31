import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-mssgbox',
  templateUrl: './mssgbox.component.html',
  styleUrls: ['./mssgbox.component.css']
})
export class MssgboxComponent implements OnInit {
  @Input() isError : boolean;
  constructor() { }

  ngOnInit(): void {
  }

}
