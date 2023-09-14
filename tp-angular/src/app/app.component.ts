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

  todos: Array<Todo> = new Array<Todo>();

  todoForm: Todo = new Todo(0, '', false);

  constructor() {
    this.todos.push(new Todo(1, 'Vérifier Mails', false));
    this.todos.push(new Todo(5, 'Finir spécifications techniques', true));
    this.todos.push(new Todo(7, 'Tests unitaires', false));
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

  ajouterTodo() {
    
    this.todos.push(this.todoForm);
    this.todoForm = new Todo(0,'', false);
  }

}
