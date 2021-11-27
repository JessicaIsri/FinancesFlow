import { PagesRoutes } from './pages.routing';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { MaterialModule } from '../material/material.module';
import { AccountComponent } from './account/account.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MovementsComponent } from './movements/movements.component';



@NgModule({
  declarations: [
    HomeComponent,
    AccountComponent,
    MovementsComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    PagesRoutes,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class PagesModule { }
