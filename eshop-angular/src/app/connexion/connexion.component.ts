import { Component } from '@angular/core';
import { UtilisateurService } from '../utilisateur/utilisateur.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {

username: string;
password: string;

constructor(private authService: AuthService) {

}

auth() {
  this.authService.authentification(this.username, this.password);
}

}
