import { Component, OnInit } from '@angular/core';
import { Category } from '../model/category';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

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
  delete(categoryId: number) {
    if (confirm("Are you sure?")) {
      this.categoryService.deleteById(categoryId).subscribe(
        () => { this.category.splice(this.category.findIndex(cat => cat.categoryId == categoryId), 1) }
      );
    }
  }
}
