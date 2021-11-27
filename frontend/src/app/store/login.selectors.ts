import {LoginState} from "./login.state";
import {createFeatureSelector, createSelector, MemoizedSelector} from "@ngrx/store";
import { User } from "../models/user.model";
import {ElementState} from "../models/element-state";


const getUser = (state: LoginState) => state.user;
const getSubmit = (state: LoginState) => state.submit;

export const selectLoginState: MemoizedSelector<object, LoginState> = createFeatureSelector<LoginState>('login');

export const selectUser: MemoizedSelector<object, User> = createSelector(
  selectLoginState,
  getUser
);

export const selectSubmit: MemoizedSelector<object, ElementState> = createSelector(
  selectLoginState,
  getSubmit
);
