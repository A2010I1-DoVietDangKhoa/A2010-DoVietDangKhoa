import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CustomerModule} from "./customer/customer.module";
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './home/home.component';
import {HeaderComponent} from "./header/header.component";

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        HomeComponent,
        HeaderComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
