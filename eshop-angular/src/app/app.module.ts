import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProduitComponent } from './produit/produit.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { MatchPasswordDirective } from './match-password.directive';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { ConnexionComponent } from './connexion/connexion.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    AccueilComponent,
    FournisseurComponent,
    ProduitComponent,
    InscriptionComponent,
    MatchPasswordDirective,
    UtilisateurComponent,
    ConnexionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
