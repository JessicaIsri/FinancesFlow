import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { createEffect, Actions, ofType } from '@ngrx/effects'
import { tap, map } from 'rxjs/operators';




@Injectable()
export class AuthEffects {

  constructor(private action$: Actions) {}



}
