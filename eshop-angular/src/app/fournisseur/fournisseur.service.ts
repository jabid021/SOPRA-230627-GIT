import { Injectable } from '@angular/core';
import { Fournisseur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  fournisseurs: Array<Fournisseur> = new Array<Fournisseur>();

  constructor() {
    this.fournisseurs.push(new Fournisseur(2, "AMAZON", "amazon@gmail.com", "Jeff BEZOS"));
    this.fournisseurs.push(new Fournisseur(7, "LECLERC", "edouard@leclerc.com", "Edouard LECLERC"));
    this.fournisseurs.push(new Fournisseur(12, "AUCHAN", "auchan@gmail.com", "Pierre DUPONT"));
   }

   findAll() : Array<Fournisseur> {
    return this.fournisseurs;
   }

   findById(id: number): Fournisseur {
    return this.fournisseurs.find(f => f.id == id);
   }

   save(fournisseur: Fournisseur): void {
    if(fournisseur.id) {
      let pos = this.fournisseurs.findIndex(f => f.id == fournisseur.id);
      this.fournisseurs[pos] = fournisseur;
    } else {
      let max = 0;
      this.fournisseurs.forEach(f => {
        if(f.id > max) {
          max = f.id;
        }
      });

      fournisseur.id = ++max;

      this.fournisseurs.push(fournisseur);
    }
   }

   deleteById(id: number) {
    let pos = this.fournisseurs.findIndex(f => f.id == id);

    this.fournisseurs.splice(pos, 1);
   }
}
