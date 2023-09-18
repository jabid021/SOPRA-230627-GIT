import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { FormsModule } from '@angular/forms';
import { ProduitComponent } from './produit/produit.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { MatchPasswordDirective } from './match-password.directive';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    AccueilComponent,
    FournisseurComponent,
    ProduitComponent,
    InscriptionComponent,
    MatchPasswordDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
