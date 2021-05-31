import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ReviewService } from '../service/review.service';

@Component({
  selector: 'app-user-review-form',
  templateUrl: './user-review-form.component.html',
  styleUrls: ['./user-review-form.component.css']
})
export class UserReviewFormComponent implements OnInit {

  
  reviewIdfc: FormControl;
  custIdfc:FormControl;
  bookidfc:FormControl;
  headlinefc:FormControl;
  commentfc:FormControl;
  ratingfc:FormControl;
  reviewOnfc:FormControl;
 

  revForm:FormGroup;
  isEditing:boolean;

  rates : string[];

constructor(private reviewService : ReviewService, private router : Router,
  private activatedRoute : ActivatedRoute) { 

    
  this.reviewIdfc = new FormControl(null);
  this.custIdfc = new FormControl(null);
   this.bookidfc = new FormControl(null);
  this.headlinefc = new FormControl(null, [Validators.required, Validators.min(10),Validators.max(20)]);
  this.commentfc = new FormControl(null, [Validators.required, Validators.min(3), Validators.max(500)]);
  this.ratingfc = new FormControl('5 Star');
  this.reviewOnfc = new FormControl(null, Validators.required);
  

  this.revForm = new FormGroup({
    reviewId : this.reviewIdfc,
    custId : this.custIdfc,
    bookid : this.bookidfc,
    headline : this.headlinefc,
    comment : this.commentfc,
    reviewOn : this.reviewOnfc,
    rating : this.ratingfc,
   

    
  });

  this.isEditing = false;
  this.rates = ["1 Star", "2 Star", "3 Star", "4 Star", "5 Star"]
  }

  ngOnInit(): void {
    let rid = this.activatedRoute.snapshot.params.rid;
    if (rid) {
      this.isEditing = true;
      this.reviewService.getById(rid).subscribe(
        (data) => this.revForm.setValue(data)
      );
    }
  } 
 
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.reviewService.update(this.revForm.value);
      alert("Review Updated");
    } else {
      obr = this.reviewService.add(this.revForm.value);
      alert("Review Added");
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/uheader/ureviews")
    );
  }

}
