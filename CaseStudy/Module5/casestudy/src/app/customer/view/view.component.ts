import { Component, OnInit } from '@angular/core';
import {Customer} from "../Customer";
import {CustomerService} from "../customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerType} from "../CustomerType";
import {CustomerTypeService} from "../customer-type.service";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  id: string;
  customer: Customer;
  customerType: CustomerType;

  constructor(public customerService: CustomerService,
              public customerTypeService: CustomerTypeService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.customerService.getById(this.id).subscribe((data: Customer) =>{
      this.customer = data;
    })
  }

  compareFn(c1: Customer, c2: Customer): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
