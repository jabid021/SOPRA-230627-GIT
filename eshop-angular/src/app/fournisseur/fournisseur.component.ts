import { Component } from '@angular/core';
import { FournisseurService } from './fournisseur.service';
import { Fournisseur } from '../model';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.scss']
})
export class FournisseurComponent {

  fournisseurForm: Fournisseur = null;
  
  constructor(private fournisseurService: FournisseurService) {

  }

  list(): Array<Fournisseur> {
    return this.fournisseurService.findAll();
  }

  add() {
    this.fournisseurForm = new Fournisseur();
  }

  edit(id: number) {
    this.fournisseurForm = {...this.fournisseurService.findById(id)};
  }

  remove(id: number) {
    this.fournisseurService.deleteById(id);
  }

  save() {
    this.fournisseurService.save(this.fournisseurForm);
  }

  cancel() {
    this.fournisseurForm = null;
  }

}
