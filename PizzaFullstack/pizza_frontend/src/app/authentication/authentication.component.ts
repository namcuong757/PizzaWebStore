import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PizzaService } from '../pizza.service';
import { Admin } from '../admin';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent {
  admin : Admin = new Admin();
  private currentAdmin : string | null = null;
  constructor(private router : Router, private pizzaService : PizzaService, private authenticatonService : AuthenticationService)
  {
    this.authenticatonService.logging();
  }
  
  authenticate(userId: string, password: string) {
    this.pizzaService.getAdminByAdminId(userId).subscribe({
      next: (adminData: Admin) => {
        this.admin = adminData;
        if (this.admin.password === password) {
          // Authentication successful
          this.authenticatonService.login(userId);
          this.router.navigate(['pizzas']);
        } else {
          // Authentication failed
          console.log('Authentication failed');
        }
      },
      error: (error) => {
        console.log('Error', error);
      }
    });
  }
  onSubmit() {
    this.authenticate(this.admin.adminID, this.admin.password);
  }
}
