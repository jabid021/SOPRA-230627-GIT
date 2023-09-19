import { Component } from '@angular/core';
import { Fournisseur, Produit } from '../model';
import { ProduitService } from './produit.service';
import { FournisseurService } from '../fournisseur/fournisseur.service';
import { Observable } from 'rxjs';
import { ProduitHttpService } from './produit-http.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent {

  produits$: Observable<Produit[]>;

  produitForm: Produit = null;

  constructor(private produitService: ProduitService, private fournisseurService: FournisseurService, private produitHttpService: ProduitHttpService) {
    this.produits$ = this.produitHttpService.findAll();
  }

  list(): Array<Produit> {
    return this.produitService.findAll();
  }

  listFournisseur(): Array<Fournisseur> {
    return this.fournisseurService.findAll();
  }

  add() {
    this.produitForm = new Produit();
    this.produitForm.fournisseur = new Fournisseur();
  }

  edit(id: number) {
    this.produitForm = {...this.produitService.findById(id)};

    if(!this.produitForm.fournisseur) {
      this.produitForm.fournisseur = new Fournisseur();
    }
  }

  // majFournisseur(event: any) {
  //   if(!this.produitForm.fournisseur) {
  //     this.produitForm.fournisseur = new Fournisseur(event);
  //   }
  // }

  save() {  
    if(this.produitForm.fournisseur.id) {
      this.produitForm.fournisseur = {...this.fournisseurService.findById(this.produitForm.fournisseur.id)};
    }

    this.produitService.save(this.produitForm);
  }

  cancel() {
    this.produitForm = null;
  }

  remove(id: number) {
    this.produitService.deleteById(id);
  }

}
