import { AuthenticateService } from '../authenticate.service'
import { User } from './../../models/user.model';

import { Component, OnInit } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable, takeWhile } from 'rxjs';
import { ElementState } from 'src/app/models/element-state';
import { AppState } from 'src/app/reducers';
import * as LoginStore from '../../store';
import { Credentials } from 'src/app/models/credentials.model';


// import { LogIn } from 'src/app/store/actions/auth.actions';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form!: FormGroup;
  submitState$?: Observable<ElementState>;
  alive = true;

  user: User = new User();
  constructor(
    private store$: Store<AppState>,
    private loginService: AuthenticateService
  ) {
    this.form = new FormGroup({
    name: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(8)])
    });
   }

  ngOnInit(): void {
    this.submitState$ = this.store$
      .pipe(select(LoginStore.selectSubmit))
      .pipe(takeWhile(() => this.alive));

    console.log(this.submitState$)
  }

  onSubmit(): void {
    if (this.form.invalid) {
      return this.store$.dispatch(new LoginStore.LoginRequestFailure({
        success: false,
        message: 'Please enter a valid email and password',
        payload: {}
      }));
    }
    const credentials: Credentials = this.form.value;
    this.loginService.login(credentials);
  }
}
