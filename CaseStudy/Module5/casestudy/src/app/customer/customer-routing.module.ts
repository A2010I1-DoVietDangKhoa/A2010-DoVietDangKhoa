import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {IndexComponent} from "./index/index.component";
import {ViewComponent} from "./view/view.component";
import {CreateComponent} from "./create/create.component";
import {EditComponent} from "./edit/edit.component";
import {HomeComponent} from "../home/home.component";

const routes: Routes = [
  { path: 'customer', redirectTo: 'customer/index', pathMatch: 'full'},
  { path: 'customer/index', component: IndexComponent },
  { path: 'customer/:id/view', component: ViewComponent },
  { path: 'customer/create', component: CreateComponent },
  { path: 'customer/:id/edit', component: EditComponent },
  { path: '', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
