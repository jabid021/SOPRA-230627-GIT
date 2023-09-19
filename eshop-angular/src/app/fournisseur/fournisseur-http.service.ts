import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fournisseur } from '../model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FournisseurHttpService {

  fournisseurs: Array<Fournisseur> = new Array<Fournisseur>();

  constructor(private http: HttpClient) { 
    this.load();
  }

  load(): void {
    let obs: Observable<Fournisseur[]> = this.http.get<Fournisseur[]>("http://localhost:8080/api/fournisseur");

    obs.subscribe(resp => {
      this.fournisseurs = resp;
    });
  }

  findAll() : Array<Fournisseur> {
    return this.fournisseurs;
  }

  findAllForAsync(): Observable<Fournisseur[]> {
    return this.http.get<Fournisseur[]>("http://localhost:8080/api/fournisseur");
  } 

  findById(id: number): Observable<Fournisseur> {
    let obs: Observable<Fournisseur> = this.http.get<Fournisseur>("http://localhost:8080/api/fournisseur/"+id);

    return obs;
  }

  save(fournisseur: Fournisseur): void {
    if(fournisseur.id) { // mise à jour
      this.http.put<Fournisseur>("http://localhost:8080/api/fournisseur/"+fournisseur.id, fournisseur).subscribe(resp => {
        this.load();
      });
    } else { // création
      this.http.post<Fournisseur>("http://localhost:8080/api/fournisseur", fournisseur).subscribe(resp => {
        this.load();
      });
    }
   }

   deleteById(id: number) {
    this.http.delete<void>("http://localhost:8080/api/fournisseur/"+id).subscribe(resp => {
      this.load();
    });
   }

  //  connexionExample(username: string, password:string) {
  //   this.http.post<any>("http://localhost:8080/api/utilisateur/connexion", {
  //     "username": username,
  //     "password": password
  //   }).subscribe(resp => {
  //     let success: boolean = resp.success;
  //     let token: string = resp.token;
  //   });
  //  }
}
