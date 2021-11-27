import { Account } from './../models/account.model';
import {User} from "../models/user.model";
import {ElementState} from "../models/element-state";

export interface LoginState {
  isAuthenticated: boolean;
  user: User;
  account: Account;
  submit: ElementState;
  errorMessage?: string | null;
}


export const initialState: LoginState = {
  isAuthenticated: false,
  user: new User(),
  account: new Account(),
  submit: new ElementState(),
  errorMessage: null
};
