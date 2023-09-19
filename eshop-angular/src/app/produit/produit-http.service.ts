import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ProduitHttpService {
  

  constructor(private http: HttpClient) {
    
  }

  findAll(): Observable<Produit[]> {
    return this.http.get<Produit[]>("http://localhost:8080/api/produit");
  }

  findById(id: number): Observable<Produit> {
    return this.http.get<Produit>("http://localhost:8080/api/produit/"+id);
  }

  save(produit: Produit): Observable<Produit> {
    if(produit.id) { // mise à jour
      return this.http.put<Produit>("http://localhost:8080/api/produit/"+produit.id, produit);
    } else { // création
      return this.http.post<Produit>("http://localhost:8080/api/produit", produit);;
    }
   }

   deleteById(id: number): Observable<void> {
    return this.http.delete<void>("http://localhost:8080/api/produit/"+id);
   }
}
