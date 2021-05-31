import { Component, OnInit } from '@angular/core';
import { Review } from '../model/review';
import { ReviewService } from '../service/review.service';

@Component({
  selector: 'app-review-list',
  templateUrl: './review-list.component.html',
  styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {

  
  reviews: Review[];
  err : string;
  
  constructor(private revsService : ReviewService) { }
  ngOnInit(): void {
    this.revsService.getAll().subscribe(
      (data) => this.reviews = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
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

