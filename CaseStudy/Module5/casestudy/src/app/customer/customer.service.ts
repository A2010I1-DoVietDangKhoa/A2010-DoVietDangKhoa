import { Injectable } from '@angular/core';
import {Customer} from "./Customer";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [];
  readonly API_URL = 'http://localhost:4200';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.API_URL + '/customer/')
      .pipe(catchError(this.errorHandler))
  }

  createCustomer(customer: Customer): Observable<any>{
    //return this.httpClient.post<any>(this.API_URL, customer);
    return this.httpClient.post(this.API_URL + '/customer/', JSON.stringify(customer), this.httpOptions)
      .pipe(catchError(this.errorHandler))
  }


  getById(id: string): Observable<Customer>{
    return this.httpClient.get<Customer>(this.API_URL + '/customer/' + id)
      .pipe(catchError(this.errorHandler))
  }

  update(id: string, customer: Customer): Observable<any>{
    return this.httpClient.put<any>(this.API_URL + '/customer/' + id, JSON.stringify(customer), this.httpOptions)
      .pipe(catchError(this.errorHandler))
  }

  delete(id: string){
    return this.httpClient.delete(this.API_URL + '/customer/' + id, this.httpOptions)
      .pipe(catchError(this.errorHandler))
  }

  errorHandler(error:any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
