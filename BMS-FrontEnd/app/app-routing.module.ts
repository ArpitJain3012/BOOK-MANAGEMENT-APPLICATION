import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerComponent } from './customer/customer.component';
import { BookFormComponent } from './book-form/book-form.component';
import { BookComponent } from './book/book.component';
import { BooklistComponent } from './booklist/booklist.component';
import { CategoryFormComponent } from './category-form/category-form.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryComponent } from './category/category.component';
import { ReviewFormComponent } from './review-form/review-form.component';
import { ReviewListComponent } from './review-list/review-list.component';
import { ReviewComponent } from './review/review.component';
import { OrderdetailComponent } from './orderdetail/orderdetail.component';
import { OrderdetailListComponent } from './orderdetail-list/orderdetail-list.component';
import { OrderdetailFormComponent } from './orderdetail-form/orderdetail-form.component';
import { BookOrderComponent } from './book-order/book-order.component';
import { BookOrderListComponent } from './book-order-list/book-order-list.component';
import { BookOrderFormComponent } from './book-order-form/book-order-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { LoginComponent } from './login/login.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { HeadcustsComponent } from './headcusts/headcusts.component';
import { UserHeaderComponent } from './user-header/user-header.component'; 
import{ UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserLoginFormComponent } from './user-login-form/user-login-form.component';
import { from } from 'rxjs';
import { UserCustomerComponent } from './user-customer/user-customer.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserProfileEditComponent } from './user-profile-edit/user-profile-edit.component';
import { UserCategoryComponent } from './user-category/user-category.component';
import { UserCategoryListComponent } from './user-category-list/user-category-list.component';
import { UserBookComponent } from './user-book/user-book.component';
import { UserBookListComponent } from './user-book-list/user-book-list.component';
import { UserBookOrderComponent } from './user-book-order/user-book-order.component';
import { UserBookOrderListComponent } from './user-book-order-list/user-book-order-list.component';
import { UserBookOrderFormComponent } from './user-book-order-form/user-book-order-form.component';
import { UserReviewComponent } from './user-review/user-review.component';
import { UserReviewListComponent } from './user-review-list/user-review-list.component';
import { UserReviewFormComponent } from './user-review-form/user-review-form.component';
import { UserCustomerFormComponent } from './user-customer-form/user-customer-form.component';
import { UserBookCategoryComponent } from './user-book-category/user-book-category.component';

const routes: Routes = [
  {
    path: 'headcusts', component: HeadcustsComponent, children: [
      { path: 'dashboard', component: DashboardComponent },
      {
        path: 'custs', component: CustomerComponent, children: [
          { path: 'list', component: CustomerListComponent },
          { path: 'add', component: CustomerFormComponent },
          { path: 'edit/:cid', component: CustomerFormComponent },
          { path: '', redirectTo: 'custs', pathMatch: 'full' },

        ]
      },
      {
        path: 'books', component: BookComponent, children: [
          { path: 'list', component: BooklistComponent },
          { path: 'add', component: BookFormComponent },
          { path: 'edit/:bookId', component: BookFormComponent },
          { path: '', redirectTo: 'books', pathMatch: 'full' },
          { path: 'headcusts', component: HeadcustsComponent }
        ]
      },
      {
        path: 'category', component: CategoryComponent, children: [
          { path: 'list', component: CategoryListComponent },
          { path: 'add', component: CategoryFormComponent },
          { path: 'edit/:categoryId', component: CategoryFormComponent },
          { path: '', redirectTo: 'category', pathMatch: 'full' },
          { path: 'headcusts', component: HeadcustsComponent }
        ]
      },
      {
        path: 'reviews', component: ReviewComponent, children: [
          { path: 'list', component: ReviewListComponent },
          { path: 'add', component: ReviewFormComponent },
          { path: 'edit/:rid', component: ReviewFormComponent },
          { path: '', redirectTo: 'reviews', pathMatch: 'full' },
          { path: 'headcusts', component: HeadcustsComponent }
        ]
      },
      {
        path: 'bookorder', component: BookOrderComponent, children: [
          { path: 'list', component: BookOrderListComponent },
          { path: 'add', component: BookOrderFormComponent },
          { path: 'edit/:orderId', component: BookOrderFormComponent },
          { path: '', redirectTo: 'bookorder', pathMatch: 'full' },
          { path: 'headcusts', component: HeadcustsComponent }
        ]
      },
      {
        path: 'orders', component: OrderdetailComponent, children: [
          { path: 'list', component: OrderdetailListComponent },
          { path: 'add', component: OrderdetailFormComponent },
          { path: 'edit/:rid', component: OrderdetailFormComponent },
          { path: '', redirectTo: 'orders', pathMatch: 'full' },
          { path: 'headcusts', component: HeadcustsComponent }
        ]
      }]
  },
  {
  path: 'uheader', component: UserHeaderComponent, children:[
    { path: 'udashboard', component: UserDashboardComponent },
    { path : 'ucustomer', component : UserCustomerComponent, children : [
      {path : 'customerDetail', component : UserProfileComponent },
      {path : 'editCustomer/:eid', component : UserProfileEditComponent },
       { path : '', redirectTo : 'customerDetail', pathMatch : 'full'}
     ]},
     {
      path: 'ucategory', component: UserCategoryComponent, children: [
        { path: 'ulist', component: UserCategoryListComponent },
        { path: '', redirectTo: 'ucategory', pathMatch: 'full' },
        { path: 'uheader', component: UserHeaderComponent }
      ]
    },
    {
      path: 'ubooks', component: UserBookComponent, children: [
        { path: 'ulist', component: UserBookListComponent },
        { path : 'ucat' ,component: UserBookCategoryComponent},
        { path: '', redirectTo: 'ubooks', pathMatch: 'full' },
        { path: 'uheader', component: UserHeaderComponent }
      ]
    },
    {
      path: 'ubookorder', component: UserBookOrderComponent, children: [
        { path: 'ulist', component: UserBookOrderListComponent },
        { path: 'uadd', component: UserBookOrderFormComponent },
        { path: 'uedit/:orderId', component: UserBookOrderFormComponent },
        { path: '', redirectTo: 'ulist', pathMatch: 'full' },
        { path: 'uheader', component: UserHeaderComponent }
      ]
    },
    {
      path: 'ureviews', component: UserReviewComponent, children: [
        { path: 'ulist', component: UserReviewListComponent },
        { path: 'uadd', component: UserReviewFormComponent },
        { path: 'uedit/:rid', component: UserReviewFormComponent },
        { path: '', redirectTo: 'ulist', pathMatch: 'full' },
        { path: 'uheader', component: UserHeaderComponent }
      ]
    },

  ]},
  {
    path: 'ulogin', component: UserLoginComponent, children:[
      { path: 'usignin', component: UserLoginFormComponent },
      { path: 'ucustadd', component: UserCustomerFormComponent },
      { path : 'uadd' , component : RegisterFormComponent},
      { path: '', redirectTo: 'usignin', pathMatch: 'full' },
    ]},
     { path: 'login', component: LoginComponent, children: [
        { path: 'signin', component: LoginFormComponent },
        { path: '', redirectTo: 'ulogin', pathMatch: 'full' }
         ]
        },
  
  { path: '', redirectTo: 'ulogin/usignin', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
