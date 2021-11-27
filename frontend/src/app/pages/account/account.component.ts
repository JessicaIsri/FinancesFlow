import { Account } from './../../models/account.model';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { PagesService } from '../pages.service';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { AppState, selectAuthState } from 'src/app/reducers';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  form!: FormGroup;
  getState: Observable<any>;
  private userId?: number;
  constructor(private pagesService: PagesService, private store$: Store<AppState>,) {
    this.getState = this.store$.select(selectAuthState);
    this.getState.subscribe((state) => {
      console.log(state)
      this.userId = state.user.id
    });
    this.form = new FormGroup({
      currentBalance: new FormControl('', [Validators.required]),
      initialBalance: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required, Validators.minLength(8)])
      });
   }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.form.value)
    const account: Account = this.form.value;
    account.userID = this.userId
    console.log(account)
    this.pagesService.newAccount(account).subscribe(ok => {
      console.log('ok')
    })
  }

}
