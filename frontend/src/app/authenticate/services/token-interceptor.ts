import { AuthenticateService } from './authenticate.service';
import { tap } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpHandler, HttpInterceptor, HttpRequest, HttpUserEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

import { TokenStorage } from './token-storage';


const TOKEN_HEADER_KEY = 'Authorization';

@Injectable({ providedIn: 'root' })
export class TokenInterceptor implements HttpInterceptor {
  constructor(private token: TokenStorage, private authenticationService: AuthenticateService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpUserEvent<any>> {
    let authReq = req;
    const token = this.token.getToken();

    if (token != null) {
      const header = {
        headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token)
      };
      authReq = req.clone(header);
    }

    return next.handle(authReq).pipe(
      tap((err: any) => {
        if (err instanceof HttpErrorResponse) {
          if (err.status >= 400) {
            this.authenticationService.logout();
          }
        }
      })
    );
  }
}
