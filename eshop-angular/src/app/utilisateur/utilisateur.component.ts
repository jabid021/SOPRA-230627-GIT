import { Component } from '@angular/core';
import { Utilisateur } from '../model';
import { UtilisateurService } from './utilisateur.service';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent {

  utilisateurForm: Utilisateur = null;

  constructor(private utilisateurService: UtilisateurService) {

  }

  list(): Array<Utilisateur> {
    return this.utilisateurService.findAll();
  }

  add() {
    this.utilisateurForm = new Utilisateur();
  }

  edit(id: number) {
    this.utilisateurForm = {...this.utilisateurService.findById(id)};
  }

  save() {
    this.utilisateurService.save(this.utilisateurForm);
  }

  cancel() {
    this.utilisateurForm = null;
  }

  remove(id: number) {
    this.utilisateurService.deleteById(id);
  }
}
