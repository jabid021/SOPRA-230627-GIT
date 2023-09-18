import { Component } from '@angular/core';
import { Utilisateur } from '../model';
import { UtilisateurService } from '../utilisateur/utilisateur.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent {
  username: string;
  password: string;
  passwordVerif: string;

  constructor(private utilisateurService: UtilisateurService) {
    console.log(this.utilisateurService.findAll());
  }

  valider() {
    this.utilisateurService.inscription(this.username, this.password);

    console.log(this.utilisateurService.findAll());
  }
}

