import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TodoComponent } from './todo/todo.component';
import { TodoDetailComponent } from './todo-detail/todo-detail.component';

const routes: Routes = [
  {path:"home", component: HomeComponent},
  {path:"todo", component: TodoComponent},
  {path:"todo/:id", component: TodoDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
