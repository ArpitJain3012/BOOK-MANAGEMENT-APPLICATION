import { Component, OnInit } from '@angular/core';
import { Category } from '../model/category';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-user-category-list',
  templateUrl: './user-category-list.component.html',
  styleUrls: ['./user-category-list.component.css']
})
export class UserCategoryListComponent implements OnInit {

  category: Category[];
  err: string;
  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(
      (data) => this.category = data,
      (err) => {
        console.log(err);
        this.err = "sorry. unable to retrieve data"
      }
    );
  }

}
