import { Component } from '@angular/core';
import { FournisseurService } from './fournisseur.service';
import { Fournisseur } from '../model';
import { FournisseurHttpService } from './fournisseur-http.service';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.scss']
})
export class FournisseurComponent {

  fournisseurForm: Fournisseur = null;
  
  constructor(private fournisseurHttpService: FournisseurHttpService) {

  }

  list(): Array<Fournisseur> {
    return this.fournisseurHttpService.findAll();
  }

  add() {
    this.fournisseurForm = new Fournisseur();
  }

  edit(id: number) {
    this.fournisseurHttpService.findById(id).subscribe(response => {
      this.fournisseurForm = response;
    });
  }

  remove(id: number) {
    this.fournisseurHttpService.deleteById(id);
  }

  save() {
    this.fournisseurHttpService.save(this.fournisseurForm);
  }

  cancel() {
    this.fournisseurForm = null;
  }

}
