import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { TodoStatePipe } from './todo-state.pipe';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscTextFieldComponent } from './asc-text-field/asc-text-field.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoStatePipe,
    AscBoldComponent,
    AscTextFieldComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
