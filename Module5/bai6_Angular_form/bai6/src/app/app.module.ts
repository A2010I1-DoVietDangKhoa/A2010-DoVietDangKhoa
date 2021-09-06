import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TodoComponent } from './PracticeUngDungTodo/todo/todo.component';
import {ReactiveFormsModule} from "@angular/forms";
import { RegisterComponent } from './ExerciseFormDangKi/register/register.component';
import { LoginComponent } from './ExerciseFormLogin/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    RegisterComponent,
    LoginComponent
  ],
    imports: [
        BrowserModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
