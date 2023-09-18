import { Injectable } from '@angular/core';
import { UtilisateurService } from './utilisateur/utilisateur.service';
import { Utilisateur } from './model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private utilisateurService: UtilisateurService) { }

  authentification(username: string, password: string) {
    let utilisateur = this.utilisateurService.connexion(username, password);

    sessionStorage.setItem("user", JSON.stringify(utilisateur));
  }

  deconnexion() {
    sessionStorage.removeItem("user");
  }

  getUtilisateur(): Utilisateur {
    let struser = sessionStorage.getItem("user");

    if(struser) {
      let utilisateur: Utilisateur = JSON.parse(struser);

      return utilisateur
    }

    return null;
  }

  isAuthenticated(): boolean {
    return this.getUtilisateur() != null;
  }

  hasRole(role: string): boolean {
    return this.getUtilisateur().roles.indexOf(role) > -1;
  }
}
