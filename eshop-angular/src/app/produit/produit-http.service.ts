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
}
