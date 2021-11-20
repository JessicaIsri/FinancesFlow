import { LayoutModule } from './infrastructure/layout/layout.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { AuthenticateModule } from './authenticate/authenticate.module';
import { StoreModule } from '@ngrx/store';
import { HttpClientModule } from '@angular/common/http';
import { metaReducers, reducers } from './reducers';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    AuthenticateModule,
    LayoutModule,
    StoreModule.forRoot(reducers, {metaReducers}),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
