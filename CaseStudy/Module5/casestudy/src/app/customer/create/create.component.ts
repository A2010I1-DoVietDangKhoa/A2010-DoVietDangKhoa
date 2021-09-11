import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../customer.service";
import {Router} from "@angular/router";
import {Customer} from "../Customer";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  form: FormGroup;

  constructor(public customerService: CustomerService,
              private router : Router) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.pattern("^(KH-)+[0-9]{4}")]),
      name: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      personalId: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern("^(090)+[0-9]{7}")]),
      address: new FormControl('', [Validators.required]),
      dateOfBirth: new FormControl('', [Validators.required]),
      //idTypeCustomer: new FormControl('', [Validators.required]),
    })
  }

  get f(){
    return this.form.controls;
  }

  compareFn(c1: Customer, c2: Customer): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  submit(){
    if (this.form.valid){
      this.customerService.createCustomer(this.form.value).subscribe(res => {
        this.router.navigateByUrl('/index/')
      })
    }
  }
}
