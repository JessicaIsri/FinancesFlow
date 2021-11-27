import { ChangeAccount } from './../../../store/login.action';
import { LayoutService } from './../layout.service';
import { AuthenticateService } from './../../../authenticate/services/authenticate.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ElementState } from 'src/app/models/element-state';
import { Store } from '@ngrx/store';
import { AppState, selectAuthState } from 'src/app/reducers';
import { GetAuthUser } from 'src/app/store';

@Component({
  selector: 'app-private-layout',
  templateUrl: './private-layout.component.html',
  styleUrls: ['./private-layout.component.css']
})
export class PrivateLayoutComponent implements OnInit {
  getState: Observable<any>;
  errorMessage: any;
  public accounts: any;
  public userName?: string | null;

  constructor(
    private authService: AuthenticateService,
    private store$: Store<AppState>,
    private layoutService: LayoutService
  ) {
    this.getState = this.store$.select(selectAuthState);
    this.store$.dispatch(new GetAuthUser())
   }

  ngOnInit(): void {
    this.getState.subscribe((state) => {
      this.errorMessage = state.errorMessage;
      this.userName = state.user.name;
      this.layoutService.getAccount(this.userName!).subscribe(
        (res) =>{
          this.accounts = res
        }
      )
    });

  }

  changeAccount(event: any): void{
    console.log('change')
    this.store$.dispatch(new ChangeAccount(event.value))
  }

  logout() :void {
    console.log('sair')
    this.authService.logout()
  }

}
