import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { from } from 'rxjs';
import { MssgboxComponent } from './mssgbox/mssgbox.component';
import { HeadcustsComponent } from './headcusts/headcusts.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookComponent } from './book/book.component';
import { BookFormComponent } from './book-form/book-form.component';
import { BooklistComponent } from './booklist/booklist.component';
import { CategoryComponent } from './category/category.component';
import { CategoryFormComponent } from './category-form/category-form.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { ReviewComponent } from './review/review.component';
import { ReviewFormComponent } from './review-form/review-form.component';
import { ReviewListComponent } from './review-list/review-list.component';
import { OrderdetailComponent } from './orderdetail/orderdetail.component';
import { OrderdetailListComponent } from './orderdetail-list/orderdetail-list.component';
import { OrderdetailFormComponent } from './orderdetail-form/orderdetail-form.component';
import { BookOrderComponent } from './book-order/book-order.component';
import { BookOrderListComponent } from './book-order-list/book-order-list.component';
import { BookOrderFormComponent } from './book-order-form/book-order-form.component';
import { LoginComponent } from './login/login.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { UserLoginFormComponent } from './user-login-form/user-login-form.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserHeaderComponent } from './user-header/user-header.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserCustomerComponent } from './user-customer/user-customer.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserProfileEditComponent } from './user-profile-edit/user-profile-edit.component';
import { UserCategoryComponent } from './user-category/user-category.component';
import { UserCategoryListComponent } from './user-category-list/user-category-list.component';
import { UserBookListComponent } from './user-book-list/user-book-list.component';
import { UserBookComponent } from './user-book/user-book.component';
import { UserBookOrderComponent } from './user-book-order/user-book-order.component';
import { UserBookOrderFormComponent } from './user-book-order-form/user-book-order-form.component';
import { UserBookOrderListComponent } from './user-book-order-list/user-book-order-list.component';
import { UserReviewListComponent } from './user-review-list/user-review-list.component';
import { UserReviewComponent } from './user-review/user-review.component';
import { UserReviewFormComponent } from './user-review-form/user-review-form.component';
import { UserCustomerFormComponent } from './user-customer-form/user-customer-form.component';
import { UserBookCategoryComponent } from './user-book-category/user-book-category.component';

@NgModule({
  declarations: [
    AppComponent,
    MssgboxComponent,
    HeadcustsComponent,
    CustomerComponent,
    CustomerFormComponent,
    CustomerListComponent,
    BookComponent,
    BookFormComponent,
    BooklistComponent,
    CategoryComponent,
    CategoryFormComponent,
    CategoryListComponent,
    ReviewComponent,
    ReviewFormComponent,
    ReviewListComponent,
    OrderdetailComponent,
    OrderdetailListComponent,
    OrderdetailFormComponent,
    BookOrderComponent,
    BookOrderFormComponent,
    BookOrderListComponent,
    LoginComponent,
    RegisterFormComponent,
    LoginFormComponent,
    DashboardComponent,
    UserLoginFormComponent,
    UserLoginComponent,
    UserHeaderComponent,
    UserDashboardComponent,
    UserCustomerComponent,
    UserProfileComponent,
    UserProfileEditComponent,
    UserCategoryComponent,
    UserCategoryListComponent,
    UserBookListComponent,
    UserBookComponent,
    UserBookOrderComponent,
    UserBookOrderFormComponent,
    UserBookOrderListComponent,
    UserReviewListComponent,
    UserReviewComponent,
    UserReviewFormComponent,
    UserCustomerFormComponent,
    UserBookCategoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
