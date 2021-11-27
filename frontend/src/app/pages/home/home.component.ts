import { Account } from './../../models/account.model';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'src/app/app.constants';
import { AppState, selectAuthState } from 'src/app/reducers';
import { getAccount } from 'src/app/store';
import { PagesService } from '../pages.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  getState: Observable<any>;
  public accounts?: Account;
  public inputs: number = 0;
  public outputs: number = 0;
  public total?: number
  public displayedColumns = ['type', 'flow', 'value', 'date']
  constructor(private pagesService: PagesService, private store$: Store<AppState>,) {
    this.getState = this.store$.select(selectAuthState);
   }


  ngOnInit(): void {
    this.getState.subscribe((account) => {
      this.accounts = account.account;
      this.getSumInputs()
      this.getMovements()
    })


  }

  getAccount(): void{

  }

  getSumInputs(): void {

    this.pagesService.getSums('in', this.accounts?.id!).subscribe(res => {
      if (res != null) {
        this.inputs = res
      } else {
        this.inputs = 0;
      }

    })
    this.pagesService.getSums('out', this.accounts?.id!).subscribe(res => {
      if (res != null) {
        this.outputs = res;
      } else {
        this.outputs = 0
      }
    })
    this.total = this.inputs + this.outputs
  }


  getMovements(): void {

  }

}
