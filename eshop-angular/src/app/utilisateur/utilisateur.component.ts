import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../model';
import { UtilisateurService } from './utilisateur.service';
import { Observable } from 'rxjs';
import { UtilisateurHttpService } from './utilisateur-http.service';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent implements OnInit {

  utilisateurs$: Observable<Utilisateur[]>;

  utilisateurForm: Utilisateur = null;

  constructor(private utilisateurHttpService: UtilisateurHttpService) {

  }
  ngOnInit(): void {
    this.utilisateurs$ = this.utilisateurHttpService.findAll();
  }

  // list(): Array<Utilisateur> {
  //   return this.utilisateurService.findAll();
  // }

  add() {
    this.utilisateurForm = new Utilisateur();
  }

  edit(id: number) {
    this.utilisateurHttpService.findById(id).subscribe(resp => {
      this.utilisateurForm = resp;
    });
  }

  save() {
    this.utilisateurHttpService.save(this.utilisateurForm).subscribe(resp => {
      this.utilisateurs$ = this.utilisateurHttpService.findAll();
    });
  }

  cancel() {
    this.utilisateurForm = null;
  }

  remove(id: number) {
    this.utilisateurHttpService.deleteById(id).subscribe(resp => {
      this.utilisateurs$ = this.utilisateurHttpService.findAll();
    });
  }
}
