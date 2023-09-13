import { Component } from '@angular/core';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  prenom = 'Eric';
  origine = '';
  couleur: string = "#000000";

  monTodo: Todo = new Todo(0, '', false);  

  constructor() {

  }

  resetPrenom() {
    this.prenom = '';
  }

  prenomUpper() {
    this.origine = this.prenom;
    this.prenom = this.prenom.toUpperCase();
  }

  prenomOrigin() {
    this.prenom = this.origine;
  }

  synchro(event: any) {
    this.prenom = event.target.value;

  }

}
