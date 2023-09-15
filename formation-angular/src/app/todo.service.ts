import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  todos: Array<Todo> = new Array<Todo>();

  constructor() { 
    this.todos.push(new Todo(1, 'Vérifier Mails', false));
    this.todos.push(new Todo(5, 'Finir spécifications techniques', true));
    this.todos.push(new Todo(7, 'Tests unitaires', false));
  }

  findAll(): Array<Todo> {
    return this.todos;
  }

  findAllByTitle(title: string): Array<Todo> {
    return this.todos.filter(todo => todo.title?.indexOf(title) != -1);
  }

  findById(id: number): Todo {
    return this.todos.find(todo => todo.id == id);
  }

  save(todo: Todo): void {
    let pos = this.todos.findIndex(t => t.id == todo.id);

    if(pos != -1) {
      this.todos[pos] = todo;
    } else {
      this.todos.push(todo);
    }
  }

  deleteById(id: number) : void {
    let pos = this.todos.findIndex(t => t.id == id);

    if(pos != -1) {
      this.todos.splice(pos, 1);
    }
  }


}
