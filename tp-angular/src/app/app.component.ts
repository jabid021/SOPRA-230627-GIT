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

  filtre: string = '';

  now: Date = new Date();

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

  saveTodo() {
    let pos = this.todos.findIndex(t => t.id == this.todoForm.id);

    if(pos != -1) {
      this.todos[pos] = this.todoForm;
    } else {
      this.todos.push(this.todoForm);
    }

    this.todoForm = new Todo(0,'', false);
  }

  editerTodo(id?: number) {
    let todo = this.todos.find(todo => todo.id == id);
    if(todo) {
     this.todoForm = {...todo};
    }
  }

  supprimerTodo(id?: number) {
    let pos = this.todos.findIndex(t => t.id == id);

    if(pos != -1) {
      this.todos.splice(pos, 1);
    }
  }

  recherche(): Array<Todo> {
    return this.todos.filter(todo => todo.title?.indexOf(this.filtre) != -1);
  }

  majPrenom(value: string) {
    this.prenom = value;
  }

 
}
