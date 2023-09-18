import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { ProduitComponent } from './produit/produit.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { authGuard } from './auth.guard';

const routes: Routes = [
  {path: "", component: AccueilComponent, pathMatch: 'full'},
  {path: "fournisseur", component: FournisseurComponent, canActivate: [authGuard]},
  {path: "produit", component: ProduitComponent, canActivate: [authGuard]},
  {path: "utilisateur", component: UtilisateurComponent, canActivate: [authGuard]},
  {path: "inscription", component: InscriptionComponent},
  {path: "connexion", component: ConnexionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
