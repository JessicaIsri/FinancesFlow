import { Account } from './../models/account.model';
import * as Actions from './login.action';
import {ActionTypes} from './login.action';
import * as State from './login.state';
import {ElementState} from '../models/element-state';
import { User } from '../models/user.model';
import { reducers } from '../reducers';
import * as LoginAction from './login.action'
import { Union } from './login.action';

export function reducer(
  state = State.initialState,
  action: Union
): State.LoginState {
  switch (action.type) {
    case Actions.ActionTypes.LOGIN_REQUEST:
      return {
        ...state,
        submit: ElementState.create(true)
      };
    case ActionTypes.LOGIN_REQUEST_SUCCESS:
      localStorage.setItem("state", JSON.stringify(action.payload));
      return {
        ...state,
        isAuthenticated: true,
        user: {
          token: action.payload.token,
          name: action.payload.name,
          email: action.payload.email,
          autorizacao: action.payload.autorizacao
        },
        errorMessage: action.payload.errorMessage
      };
    case ActionTypes.GET_AUTH_USER:
      const user: User = JSON.parse(localStorage.getItem("state")!);
      return {
        ...state,
        user:{
          token: user.token,
          name: user.name,
          email: user.email,
          autorizacao: user.autorizacao,
          id: user.id
        }
      }
    case ActionTypes.CHANGE_ACCOUNT:
      localStorage.setItem("account", JSON.stringify(action.payload));
      return {
        ...state,
        account: {
          currentBalance: action.payload.currentBalance,
          initialBalance: action.payload.initialBalance,
          id: action.payload.id
        }
      }
    case ActionTypes.GET_ACCOUNT:
      const account: Account =  JSON.parse(localStorage.getItem("account")!);
      return {
        ...state,
        account: {
          currentBalance: account.currentBalance,
          initialBalance: account.initialBalance,
          id:account.id
        }
      }
    case ActionTypes.LOGIN_REQUEST_FAILURE:
      return {
        ...state,
        submit: ElementState.error(action.payload.error)
      };
    default:
      return state;
  }
}


