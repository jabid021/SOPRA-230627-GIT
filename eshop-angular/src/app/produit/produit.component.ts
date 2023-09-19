import { Component, OnInit } from '@angular/core';
import { Fournisseur, Produit } from '../model';
import { ProduitService } from './produit.service';
import { FournisseurService } from '../fournisseur/fournisseur.service';
import { Observable } from 'rxjs';
import { ProduitHttpService } from './produit-http.service';
import { FournisseurHttpService } from '../fournisseur/fournisseur-http.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent implements OnInit{

  produits$: Observable<Produit[]>;

  fournisseurs$: Observable<Fournisseur[]>;

  produitForm: Produit = null;

  constructor(private produitHttpService: ProduitHttpService, private fournisseurHttpService: FournisseurHttpService) {
  }
  
  ngOnInit(): void {
    this.produits$ = this.produitHttpService.findAll();
    this.fournisseurs$ = this.fournisseurHttpService.findAllForAsync();
  }

  // list(): Array<Produit> {
  //   return this.produitService.findAll();
  // }

  // listFournisseur(): Array<Fournisseur> {
  //   return this.fournisseurService.findAll();
  // }

  add() {
    this.produitForm = new Produit();
    this.produitForm.fournisseur = new Fournisseur();
  }

  edit(id: number) {
    this.produitHttpService.findById(id).subscribe(resp => {
      this.produitForm = resp;

      if(!this.produitForm.fournisseur) {
        this.produitForm.fournisseur = new Fournisseur();
      }
    });
  }

  // majFournisseur(event: any) {
  //   if(!this.produitForm.fournisseur) {
  //     this.produitForm.fournisseur = new Fournisseur(event);
  //   }
  // }

  save() {  
    this.produitHttpService.save(this.produitForm).subscribe(resp => {
      this.produits$ = this.produitHttpService.findAll();
    });
  }

  cancel() {
    this.produitForm = null;
  }

  remove(id: number) {
    this.produitHttpService.deleteById(id).subscribe(resp => {
      this.produits$ = this.produitHttpService.findAll();
    });
  }

}
