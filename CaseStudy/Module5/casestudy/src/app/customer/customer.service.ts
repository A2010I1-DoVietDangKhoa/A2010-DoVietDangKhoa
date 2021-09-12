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
  readonly API_URL = 'http://localhost:3000/customers';
  // httpOptions = {
  //   headers: new HttpHeaders({
  //     'Content-Type': 'application/json'
  //   })
  // }

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.API_URL)
      //.pipe(catchError(this.errorHandler))
  }

  createCustomer(customer: Customer): Observable<any>{
    //return this.httpClient.post<any>(this.API_URL, customer);
    return this.httpClient.post<any>(this.API_URL, customer)
    //  .pipe(catchError(this.errorHandler))
  }


  getById(id: string): Observable<Customer>{
    return this.httpClient.get<Customer>(this.API_URL + '/' + id)
     // .pipe(catchError(this.errorHandler))
  }

  update(id: string, customer: Customer): Observable<any>{
    return this.httpClient.put(this.API_URL + '/' + id, customer)
     // .pipe(catchError(this.errorHandler))
  }

  delete(id: string): Observable<Customer>{
    return this.httpClient.delete<Customer>(this.API_URL + '/' + id)
    //  .pipe(catchError(this.errorHandler))
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
