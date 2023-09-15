import { Component } from '@angular/core';
import { Todo } from '../todo';
import { Router } from '@angular/router';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})
export class TodoComponent {

  todoForm: Todo = new Todo(0, '', false);

  filtre: string = '';

  constructor(private router: Router, private todoService: TodoService) {
   
  }

  saveTodo() {
    this.todoService.save(this.todoForm);

    this.todoForm = new Todo(0,'', false);
  }

  editerTodo(id?: number) {
    let todo = this.todoService.findById(id);
    if(todo) {
     this.todoForm = {...todo};
    }
  }

  supprimerTodo(id?: number) {
    this.todoService.deleteById(id);
  }

  recherche(): Array<Todo> {
    return this.todoService.findAllByTitle(this.filtre);
  }

  detail(id: number) {
    this.router.navigate(['/todo', id]);
  }
}
