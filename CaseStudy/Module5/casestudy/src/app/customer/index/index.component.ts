import {Component, Inject, OnInit} from '@angular/core';
import {Customer} from "../Customer";
import {CustomerService} from "../customer.service";
import {DeleteComponent} from "../delete/delete.component";
import {CustomerTypeService} from "../customer-type.service";
import {MatDialog} from "@angular/material/dialog";
import {CustomerType} from "../CustomerType";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {
  customers: Customer[] = [];
  customer: Customer;
  customerTypes : CustomerType[];
  id: string;
  name: string;
  //dialog: HTMLDialogElement;
  searchName = '';
  searchCustomerTypeName = '';
  p: any;

  constructor(public customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private dialog: MatDialog) { }

  ngOnInit(): void {
    this.customerService.getAll().subscribe((data: Customer[]) =>{
      this.customers = data;
    });
    this.customerTypeService.getAllType().subscribe((data: CustomerType[]) => {
      this.customerTypes = data;
    })
  }

  // delete(id: string) {
  //   this.customerService.delete(id).subscribe(res => {
  //     this.customers = this.customers.filter(item => item.id !== id);
  //   })
  // }

  search() {
    this.customerService.search(this.searchName, this.searchCustomerTypeName).subscribe(data => {
      this.customers = data;
    });
  }

  openDialogDelete(id: string, name: string) {
    const dialog = this.dialog.open(DeleteComponent, {
      width: '350px',
      height: '250px',
      // position: {
      //   bottom: '200px',
      //   left: '0px'
      // },
      data: {id: id, name: name}
    });
    dialog.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }

}
