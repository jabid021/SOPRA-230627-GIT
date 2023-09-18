import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from './auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);

  if (!authService.isAuthenticated()) {
    const router = inject(Router);
    router.navigate([ '/connexion' ]);
  }

  if(state.url == "/utilisateur" && !authService.hasRole("ADMIN")) {
    return false;
  }

  return true;
};
