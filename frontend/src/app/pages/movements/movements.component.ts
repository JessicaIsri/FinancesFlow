import { Movements } from './../../models/movements.model';
import { LayoutService } from './../../infrastructure/layout/layout.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { AppState, selectAuthState } from 'src/app/reducers';
import { PagesService } from '../pages.service';

@Component({
  selector: 'app-movements',
  templateUrl: './movements.component.html',
  styleUrls: ['./movements.component.css']
})
export class MovementsComponent implements OnInit {
  form!: FormGroup;
  getState: Observable<any>;
  private userId?: number;
  accounts: any;
  constructor(private pagesService: PagesService, private layoutService: LayoutService,  private store$: Store<AppState>) {
    this.getState = this.store$.select(selectAuthState);
    this.getState.subscribe((state) => {
      console.log(state)
      this.userId = state.user.id
    });
    this.form = new FormGroup({
      type: new FormControl('', [Validators.required]),
      value: new FormControl('', [Validators.required]),
      accountId: new FormControl('', [Validators.required]),
      flow: new FormControl('', [Validators.required])
      });
  }

  ngOnInit(): void {
    this.getState.subscribe((state) => {
      const user = state.user.name;
      this.layoutService.getAccount(user).subscribe(
        (res) =>{
          this.accounts = res
        }
      )
    });
  }

  onSubmit(): void {
    const movements: Movements = this.form.value;
    this.pagesService.newMovements(movements).subscribe(ok => {
      console.log('ok')
    })
  }

}
