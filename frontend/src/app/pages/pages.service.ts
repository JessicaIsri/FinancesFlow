import { Account } from './../models/account.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from '../app.constants';
import { Movements } from '../models/movements.model';

@Injectable({
  providedIn: 'root'
})
export class PagesService {

  constructor(private http: HttpClient,) { }
  private url = SERVER_API_URL
  getSums(flow: string, account: number): Observable<number> {
    return this.http.get<number>(this.url + '/movements/Sum/' + flow + '/' + account)
  }

  newAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(this.url + '/account/new', account)
  }

  newMovements(movements: Movements): Observable<Movements> {
    return this.http.post<Movements>(this.url + '/movements/new', movements)
  }
}
