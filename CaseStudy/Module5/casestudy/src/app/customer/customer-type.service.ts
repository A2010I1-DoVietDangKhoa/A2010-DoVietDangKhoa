import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerType} from "./CustomerType";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  private API_URL = 'http://localhost:3000/customerTypes';

  constructor(private httpClient: HttpClient) { }

  getAllType(): Observable<CustomerType[]>{
    return this.httpClient.get<CustomerType[]>(this.API_URL);
  }

  findById(id: string): Observable<CustomerType> {
    // @ts-ignore
    return this.http.get<CustomerType>(this.httpClient + '/' + id);
  }
}
