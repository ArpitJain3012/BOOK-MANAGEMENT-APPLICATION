import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {
  categoryIdfc : FormControl ;
  categoryNamefc : FormControl ;

  categoryForm : FormGroup;

  isEditing : boolean;

constructor(private categoryService: CategoryService, private router: Router, private activatedRoute: ActivatedRoute) {
  this.categoryIdfc= new FormControl(null) ;
  this.categoryNamefc = new FormControl (null, [Validators.required]);

  this.categoryForm = new FormGroup({
    categoryId : this.categoryIdfc,
    categoryName : this.categoryNamefc 
  });
  this.isEditing = false;
}

 

ngOnInit(): void {
  let categoryId = this.activatedRoute.snapshot.params.categoryId;
  if (categoryId) {
    this.isEditing = true;
    this.categoryService.getById(categoryId).subscribe(
      (data) => this.categoryForm.setValue(data)
    );
  }
}

  handleSubmit() {
    let obr =null;
    if(this.isEditing){
      obr=this.categoryService.update(this.categoryForm.value);
      alert("Category Added");
    }else{
      obr=this.categoryService.add(this.categoryForm.value);
      alert("Category Added");
    }
    obr.subscribe(
      (data) =>this.router.navigateByUrl("/headcusts/category")
    );
   
}
}