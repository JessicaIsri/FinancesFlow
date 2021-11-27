import { Account } from './../../models/account.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Store } from '@ngrx/store';
import { SERVER_API_URL } from 'src/app/app.constants';
import { AppState } from 'src/app/reducers';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LayoutService {
  private url = SERVER_API_URL
  constructor(private http: HttpClient,) { }

  getAccount(user: string): Observable<Account[]>{
    return this.http.get<Account[]>(this.url + '/account/listAll/'+ user);
  }
}
