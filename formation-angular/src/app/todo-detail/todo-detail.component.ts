import { Component } from '@angular/core';
import { Todo } from '../todo';
import { ActivatedRoute } from '@angular/router';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrls: ['./todo-detail.component.css']
})
export class TodoDetailComponent {
  currentTodo: Todo;
  
  constructor(private route: ActivatedRoute, private todoService: TodoService) {
    this.route.params.subscribe(parameters => {
      let id = parameters['id'];

      this.currentTodo = this.todoService.findById(id);
    });
  }
}
