import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatDialogModule} from '@angular/material/dialog';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CustomerModule} from "./customer/customer.module";
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './home/home.component';
import {HeaderComponent} from "./header/header.component";
import { FooterComponent } from './footer/footer.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgxPaginationModule} from "ngx-pagination";
import {IndexComponent} from "./customer/index/index.component";
import {DeleteComponent} from "./customer/delete/delete.component";

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        HeaderComponent,
        FooterComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule,
    NgxPaginationModule
  ],
  // entryComponents:[
  //   IndexComponent,
  //   DeleteComponent
  // ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
