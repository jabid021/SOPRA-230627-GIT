import { Component } from '@angular/core';
import { Todo } from '../todo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent {
  todos: Array<Todo> = new Array<Todo>();

  todoForm: Todo = new Todo(0, '', false);

  filtre: string = '';

  constructor(private router: Router) {
    this.todos.push(new Todo(1, 'Vérifier Mails', false));
    this.todos.push(new Todo(5, 'Finir spécifications techniques', true));
    this.todos.push(new Todo(7, 'Tests unitaires', false));
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

  detail(id: number) {
    this.router.navigate(['/todo', id]);
  }
}
