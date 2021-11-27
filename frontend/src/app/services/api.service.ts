import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { SERVER_API_URL } from '../app.constants';
import { User } from '../models/user.model';
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiURL = SERVER_API_URL
  constructor(private http: HttpClient,) {

  }

  postUserLogin(user: User) {
    return this.http.post(`${this.apiURL}/auth/login`, user)
    .pipe(
      tap((res: User) => {
       // authentication and local storage code can go here
    })
   );
  }
}
