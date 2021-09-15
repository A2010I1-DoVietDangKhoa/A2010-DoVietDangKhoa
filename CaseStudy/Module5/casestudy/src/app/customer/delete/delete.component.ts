import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from "../customer.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.scss']
})
export class DeleteComponent implements OnInit {
  id: string;
  name: string;

  constructor(public dialog: MatDialogRef<DeleteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              public customerService: CustomerService) { }

  ngOnInit(): void {
    this.id = this.data.id;
    this.name = this.data.name;
  }

  delete(){
    this.customerService.delete(this.id).subscribe(() => {
      this.dialog.close();
    });
  }

  close(){
    this.dialog.close();
  }

}
