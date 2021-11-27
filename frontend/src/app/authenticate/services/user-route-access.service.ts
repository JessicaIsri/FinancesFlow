import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
// import { AuthenticationService } from './authentication.service';
// import { AuthorityService } from './authority.service';

@Injectable({ providedIn: 'root' })
export class UserRouteAccessService  {
  // constructor(private router: Router, private authenticationService: AuthenticationService, private authorityService: AuthorityService) {}

  // canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Promise<boolean> {
  //   if (!this.authenticationService.isAuthenticated()) {
  //     this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
  //     return false;
  //   }

  //   // Get requested authorities
  //   const requestedAuthorities = route.data.authorities;

  //   // If authorities aren't necessary
  //   if (!requestedAuthorities || requestedAuthorities.length === 0) {
  //     return true;
  //   }

  //   // Check authorities if they are necessary
  //   return this.authorityService
  //     .hasAuthority(requestedAuthorities)
  //     .then((response) => {
  //       if (!response) {
  //         this.router.navigate(['/not-authorized']);
  //       }
  //       return response;
  //     })
  //     .catch((err) => {
  //       this.router.navigate(['/not-authorized']);
  //       return false;
  //     });
  // }
}
