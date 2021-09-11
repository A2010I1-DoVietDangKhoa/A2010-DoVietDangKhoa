import { Component, OnInit } from '@angular/core';
import {Customer} from "../Customer";
import {CustomerService} from "../customer.service";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {
  customers: Customer[] = [];
  customer: Customer;


  constructor(public customerService: CustomerService) { }

  ngOnInit(): void {
    this.customerService.getAll().subscribe((data: Customer[]) =>{
      this.customers = data;
    })
  }

  delete(id: string){
    this.customerService.delete(id).subscribe(res => {
      this.customers = this.customers.filter(item => item.id !== id);
    })
  }
}
