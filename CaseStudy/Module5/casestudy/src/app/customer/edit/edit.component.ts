import { Component, OnInit } from '@angular/core';
import {Customer} from "../Customer";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../customer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {
  id: string;
  customer: Customer;
  form: FormGroup;

  constructor(
    public customerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.customerService.getById(this.id).subscribe((data: Customer) =>{
      this.customer = data;
    });
    this.form = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.pattern("^(KH-)+[0-9]{4}")]),
      name: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      personalId: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      phone: new FormControl('', [Validators.required, Validators.pattern("^(090)+[0-9]{7}")]),
      address: new FormControl('', [Validators.required]),
      dateOfBirth: new FormControl('', [Validators.required])
    })
  }

  get f(){
    return this.form.controls;
  }

  compareFn(c1: Customer, c2: Customer): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  submit(){
    if (this.form.valid) {
      this.customerService.update(this.id, this.form.value).subscribe(res => {
        this.router.navigateByUrl('/index/')
      })
    }
  }
}
