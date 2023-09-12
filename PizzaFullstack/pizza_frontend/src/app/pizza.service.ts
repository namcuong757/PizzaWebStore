import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Route, Router } from '@angular/router';
import { Pizza } from './pizza';
import { Admin } from './admin';
@Injectable({
  providedIn: 'root'
})
export class PizzaService {
  private baseURL = "http://localhost:8080/api/p1/pizzas";
  private adminURL = "http://localhost:8080/api/admin";
  constructor(private httpClient : HttpClient, private router:Router) {}
  getPizzaList(): Observable<Pizza []>
  {
    return this.httpClient.get<Pizza[]>(`${this.baseURL}`);
  }
  createPizza(pizza : Pizza): Observable<Object>
  {
    return this.httpClient.post<any>(`${this.baseURL}`, pizza);
  }
  getPizzaById(id : number) : Observable<Pizza>
  {
    return this.httpClient.get<Pizza>(`${this.baseURL}/${id}`);
  }
  updatePizza(id : number, pizza : Pizza) : Observable<Object>
  {
    return this.httpClient.put<Pizza>(`${this.baseURL}/${id}`, pizza);
  }
  deletePizza(id : number) : Observable<Object>
  {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
  getAdminByAdminId(adminID : string | null) : Observable<Admin>
  {
    return this.httpClient.get<Admin>(`${this.adminURL}/${adminID}`);
  }
  createAdmin(admin : Admin): Observable<Object>
  {
    return this.httpClient.post<any>(`${this.adminURL}`, admin);
  }
  updateAdmin(adminID : string, admin : Admin): Observable<Admin>
  {
    return this.httpClient.put<Admin>(`${this.adminURL}/${adminID}`, admin);
  }
}
