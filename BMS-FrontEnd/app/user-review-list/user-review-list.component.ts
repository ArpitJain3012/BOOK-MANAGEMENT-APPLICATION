import { Component, OnInit } from '@angular/core';
import { Review } from '../model/review';
import { LoginService } from '../service/login.service';
import { ReviewService } from '../service/review.service';

@Component({
  selector: 'app-user-review-list',
  templateUrl: './user-review-list.component.html',
  styleUrls: ['./user-review-list.component.css']
})
export class UserReviewListComponent implements OnInit {

  reviews: Review[];
  err : string;
  
  constructor(private revsService : ReviewService,private loginService :LoginService) { }
  ngOnInit(): void {
    console.log(this.loginService.currentCustomer.customerId);
    this.revsService.getReviewsByCustomerId(this.loginService.currentCustomer.customerId).subscribe(
      (data) =>{ this.reviews = data;console.log(data);},
      (err) => {
        console.log(err);
        this.err = "sorry. unable to retrieve data"
      }
    );
  }
  delete(empId: number) {
    if (confirm("Are you sure?")) {
      this.revsService.deleteById(empId).subscribe(
        () => { this.reviews.splice(this.reviews.findIndex(e => e.reviewId == empId), 1) }
      );
    }
  }
}
