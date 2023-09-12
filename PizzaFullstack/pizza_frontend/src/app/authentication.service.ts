import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private router : Router){}
  private isAuthenticated: boolean = false;
  private isLogging: boolean = false;
  private currentAdmin : string | null = null;
  login(adminID : string) {
    this.isAuthenticated = true;
    this.currentAdmin = adminID;
  }

  logout() {
    this.isAuthenticated = false;
    this.isLogging = false;
    this.currentAdmin = null;
    this.router.navigate(['homepage']);
  }
  logging(){
    this.isLogging = true;
  }
  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }
  isLoggingIn(): boolean{
    return this.isLogging;
  }
  getCurrentAdmin()
  {
    return this.currentAdmin;
  }
}
