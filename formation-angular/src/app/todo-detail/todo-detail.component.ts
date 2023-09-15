import { Component } from '@angular/core';
import { Todo } from '../todo';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrls: ['./todo-detail.component.css']
})
export class TodoDetailComponent {
  todos: Array<Todo> = new Array<Todo>();

  currentTodo: Todo;
  
  constructor(private route: ActivatedRoute) {
    this.todos.push(new Todo(1, 'Vérifier Mails', false));
    this.todos.push(new Todo(5, 'Finir spécifications techniques', true));
    this.todos.push(new Todo(7, 'Tests unitaires', false));

    this.route.params.subscribe(parameters => {
      let id = parameters['id'];

      this.currentTodo = this.todos.find(t => t.id == id);
    });
  }
}
