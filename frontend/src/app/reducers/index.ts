
import {
  Action,
  ActionReducerMap,
  createFeatureSelector,
  MetaReducer
} from '@ngrx/store';
import {environment} from '../../environments/environment';
import { LoginState} from "../store/login.state";

import * as LoginStore from '../store';

export interface AppState {
  login: LoginStore.LoginState;
}

export const reducers: ActionReducerMap<AppState, any> = {
  login: LoginStore.reducer
};

export const selectAuthState = createFeatureSelector<AppState>('login');
export const metaReducers: MetaReducer<AppState>[] =  [];
