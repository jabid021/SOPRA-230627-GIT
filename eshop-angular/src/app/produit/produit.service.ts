import { Injectable } from '@angular/core';
import { Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  produits: Array<Produit> = new Array<Produit>();

  constructor() {
    this.produits.push(new Produit(1,"Iphone 12",700, 1200,"SuperBien","Iphone",150));
    this.produits.push(new Produit(5,"Samsung Galaxy s22", 400, 800, "Encoremieux","Samsung",120));
    this.produits.push(new Produit(10,"Alcatel",30, 120,'pasOuf',"Generique",500));
   }

   findAll() : Array<Produit> {
    return this.produits;
   }

   findById(id: number): Produit {
    return this.produits.find(p => p.id == id);
   }

   save(produit: Produit): void {
    if(produit.id) {
      let pos = this.produits.findIndex(prod => prod.id == produit.id);
      this.produits[pos] = produit;
    } else {
      let max = 0;
      this.produits.forEach(p => {
        if(p.id > max) {
          max = p.id;
        }
      });

      produit.id = ++max;

      this.produits.push(produit);
    }
   }

   deleteById(id: number) {
    let pos = this.produits.findIndex(p => p.id == id);

    this.produits.splice(pos, 1);
   }
}
