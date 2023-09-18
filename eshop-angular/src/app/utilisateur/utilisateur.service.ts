import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor() {
    this.utilisateurs.push(new Utilisateur(3, "manon", "123456", "EVEN", "Manon", false, "USER"));
    this.utilisateurs.push(new Utilisateur(5, "anais", "123456", "PORTET", "Anaïs", false, "USER", "ADMIN"));
    this.utilisateurs.push(new Utilisateur(13, "rawad", "123456", "ANDRAOS", "Rawad", false, "ADMIN"));
   }


   findAll() : Array<Utilisateur> {
    return this.utilisateurs;
   }

   findById(id: number): Utilisateur {
    return this.utilisateurs.find(u => u.id == id);
   }

   save(utilisateur: Utilisateur): void {
    if(utilisateur.id) {
      let pos = this.utilisateurs.findIndex(u => u.id == utilisateur.id);
      this.utilisateurs[pos] = utilisateur;
    } else {
      let max = 0;
      this.utilisateurs.forEach(u => {
        if(u.id > max) {
          max = u.id;
        }
      });

      utilisateur.id = ++max;

      this.utilisateurs.push(utilisateur);
    }
   }

   deleteById(id: number) {
    let pos = this.utilisateurs.findIndex(u => u.id == id);

    this.utilisateurs.splice(pos, 1);
   }

   inscription(username: string, password: string) {
    let utilisateur: Utilisateur = new Utilisateur(null, username, password);
    utilisateur.roles.push("USER");

    this.save(utilisateur);
   }
}
