import { Account } from './../models/account.model';
import { HomeComponent } from './home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { MovementsComponent } from './movements/movements.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'account', component: AccountComponent},
  { path: 'movements', component: MovementsComponent}
];

export const PagesRoutes = RouterModule.forChild(routes);
