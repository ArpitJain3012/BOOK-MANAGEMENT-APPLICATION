import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _currentCustomer: Login;

  loginApi: string;

  constructor(private httpClient: HttpClient) {
    this.currentCustomer = null;
    this.loginApi = "http://localhost:8082/login";
  }
  get currentCustomer() {
    return this._currentCustomer;
  }

  set currentCustomer(cc: Login) {
    this._currentCustomer = cc;
  }

  singIn(login: Login): Observable<Login> {
    return this.httpClient.post<Login>(`${this.loginApi}/signin`, login);
  }

  add(login: Login): Observable<Login> {
    return this.httpClient.post<Login>(this.loginApi, login);
  }

}
