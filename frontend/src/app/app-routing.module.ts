import { PrivateLayoutComponent } from './infrastructure/layout/private-layout/private-layout.component';
import { PublicLayoutComponent } from './infrastructure/layout/public-layout/public-layout.component';
import { RegisterComponent } from './authenticate/register/register.component';
import { LoginComponent } from './authenticate/login/login.component'
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: PrivateLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('./pages/pages.module').then((m) => m.PagesModule),
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
