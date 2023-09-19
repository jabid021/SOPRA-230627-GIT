import { Component } from '@angular/core';
import { Utilisateur } from '../model';
import { UtilisateurService } from '../utilisateur/utilisateur.service';
import { UtilisateurHttpService } from '../utilisateur/utilisateur-http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent {
  username: string;
  password: string;
  passwordVerif: string;

  constructor(private utilisateurHttpService: UtilisateurHttpService, private router: Router) {
  }

  valider() {
    this.utilisateurHttpService.inscription(this.username, this.password, this.passwordVerif).subscribe(resp => {
      this.router.navigate(["/connexion"]);
    });
  }
}

