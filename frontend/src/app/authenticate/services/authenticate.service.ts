import { Injectable } from '@angular/core';
import { Observable, of, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { SERVER_API_URL } from '../../app.constants';
import { Store } from '@ngrx/store';
import { AppState } from '../../reducers';
import { Credentials } from '../../models/credentials.model';
import { LoginRequest, LoginRequestFailure, LoginRequestSuccess } from '../../store';
import { StandardResponseDto } from '../../models/standart-response';
import { User } from '../../models/user.model';
import { ErrorResponseDto } from '../../models/erro-response';
import { TokenStorage } from '.';


@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {
  private url = SERVER_API_URL
  constructor(
    private http: HttpClient,
    private store$: Store<AppState>,
    private storage: TokenStorage,
    private router: Router) {

  }

  login(credentials: Credentials): void {
    this.store$.dispatch(new LoginRequest());
    this.makeLoginRequest(credentials).subscribe(
      success => this.store$.dispatch(new LoginRequestSuccess(success)),
      error => this.store$.dispatch(new LoginRequestFailure(error))
    );
  }

  private makeLoginRequest(credentials: Credentials): Observable<User> {
    const subject = new Subject<User>();

    // I'm using a setTimeout to imitate an http call
    setTimeout(() => {

      this.http.post(this.url + '/login', credentials).subscribe((sucess: User) => {

        this.store$.dispatch(
          new LoginRequestSuccess(sucess))
        this.storage.saveToken(sucess.token!)
        this.router.navigate(['home'])
        subject.next(new User({
          id: sucess.id,
          name: sucess.name,
          email: sucess.email,
          token: sucess.token
        }));
      }, (erro: Error) => {
        subject.error(new Error('Erro no login'));
      })


    }, 500);

    return subject.asObservable();
  }

  logout() {
    this.storage.signOut();
    this.router.navigate(['login']);
  }
}
