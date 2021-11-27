import {Action} from "@ngrx/store";
import { Credentials } from "../models/credentials.model";
import { User } from "../models/user.model";
import { Error } from "../models/erro.model";
import { ErrorResponseDto } from "../models/erro-response";
import { StandardResponseDto } from "../models/standart-response";
import { Account } from "../models/account.model";

export enum ActionTypes {
  GET_AUTH_USER = '[User] Get User',
  CHANGE_ACCOUNT = '[Account] Make Request',
  GET_ACCOUNT = '[Account] Get Account',
  LOGIN_REQUEST = '[Login] Make Request',
  LOGIN_REQUEST_SUCCESS = '[Login] Request Success',
  LOGIN_REQUEST_FAILURE = '[Login] Request Failure'
}


export class LoginRequest implements Action {
  readonly type = ActionTypes.LOGIN_REQUEST;
  constructor() {}
}

export class LoginRequestSuccess implements Action {
  readonly type = ActionTypes.LOGIN_REQUEST_SUCCESS;
  constructor(public payload: User) {

  }
}

export class GetAuthUser implements Action {
  readonly type = ActionTypes.GET_AUTH_USER;
  constructor() {

  }
}

export class ChangeAccount implements Action{
  readonly type = ActionTypes.CHANGE_ACCOUNT;
  constructor(public payload: Account) {

  }
}

export class getAccount implements Action{
  readonly type = ActionTypes.GET_ACCOUNT;
  constructor() {

  }
}

export class LoginRequestFailure implements Action {
  readonly type = ActionTypes.LOGIN_REQUEST_FAILURE;
  constructor(public payload: Error) {}
}

export type Union =
LoginRequest |
LoginRequestSuccess |
LoginRequestFailure |
GetAuthUser|
ChangeAccount |
getAccount;

