import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fournisseur } from '../model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FournisseurHttpService {

  fournisseurs: Array<Fournisseur> = new Array<Fournisseur>();
  apiFournisseurUrl: string = environment.apiUrl + "/fournisseur";

  constructor(private http: HttpClient) { 
    this.load();
  }

  load(): void {
    let obs: Observable<Fournisseur[]> = this.http.get<Fournisseur[]>(this.apiFournisseurUrl);

    obs.subscribe(resp => {
      this.fournisseurs = resp;
    });
  }

  findAll() : Array<Fournisseur> {
    return this.fournisseurs;
  }

  findAllForAsync(): Observable<Fournisseur[]> {
    return this.http.get<Fournisseur[]>(this.apiFournisseurUrl);
  } 

  findById(id: number): Observable<Fournisseur> {
    let obs: Observable<Fournisseur> = this.http.get<Fournisseur>(this.apiFournisseurUrl + "/"+id);

    return obs;
  }

  save(fournisseur: Fournisseur): void {
    if(fournisseur.id) { // mise à jour
      this.http.put<Fournisseur>(this.apiFournisseurUrl + "/"+fournisseur.id, fournisseur).subscribe(resp => {
        this.load();
      });
    } else { // création
      this.http.post<Fournisseur>(this.apiFournisseurUrl, fournisseur).subscribe(resp => {
        this.load();
      });
    }
   }

   deleteById(id: number) {
    this.http.delete<void>(this.apiFournisseurUrl + "/"+id).subscribe(resp => {
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
